package com.unesco.core.services.account.userService;

import com.unesco.core.entities.account.UserEntity;
import com.unesco.core.models.account.RoleDTO;
import com.unesco.core.models.account.UserDTO;
import com.unesco.core.models.additional.FilterQueryDTO;
import com.unesco.core.repositories.account.UserRepository;
import com.unesco.core.services.account.roleService.RoleDataService;
import com.unesco.core.services.mapperService.IMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService implements IUserDataService {
    @Autowired
    private IMapperService mapperService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleDataService roleDataService;

    public List<UserDTO> GetPage(FilterQueryDTO filter) {
        int rows = filter.getRows()>0? filter.getRows() : (int) userRepository.count();
        int start = rows>0 ? filter.getFirst()/rows: 1;
        List<UserEntity> entitys = userRepository.findWithFilter(new PageRequest(start, rows == 0 ? 10 : rows), filter.getGlobalFilter());
        List<UserDTO> result = new ArrayList<UserDTO>();
        for (UserEntity e: entitys) {
            result.add((UserDTO) mapperService.toModel(e));
        }
        return result;
    }

    public List<UserDTO> GetAll()
    {
        List<UserDTO> modelList = new ArrayList<>();
        Iterable<UserEntity> entityList = userRepository.findAll();
        for (UserEntity item: entityList) {
            UserDTO model = (UserDTO) mapperService.toModel(item);
            modelList.add(model);
        }
        return modelList;
    }

    public UserDTO Get(long id)
    {
        UserEntity entity = userRepository.findOne(id);
        UserDTO model = (UserDTO) mapperService.toModel(entity);
        return model;
    }

    public UserDTO GetByUsername(String username)
    {
        UserEntity entity = userRepository.findByUsername(username);
        UserDTO model = (UserDTO) mapperService.toModel(entity);
        return model;
    }

    public void Delete(long id)
    {
        userRepository.delete(id);
    }

    public UserDTO Save(UserDTO user)
    {
        List<RoleDTO> roles = new ArrayList<>();
        for (RoleDTO role:  user.getRoles()) {
            RoleDTO findRole = roleDataService.GetByName(role.roleName);
            if(findRole != null) {
                roles.add(findRole);
            }
        }
        user.setRoles(roles);

        UserEntity entity = (UserEntity) mapperService.toEntity(user);
        entity = userRepository.save(entity);

        UserDTO model = (UserDTO) mapperService.toModel(entity);
        return model;
    }

}
