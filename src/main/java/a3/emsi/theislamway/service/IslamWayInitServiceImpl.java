package a3.emsi.theislamway.service;

import a3.emsi.theislamway.dao.GroupRepository;
import a3.emsi.theislamway.dao.HizbRepository;
import a3.emsi.theislamway.dao.UserRepository;
import a3.emsi.theislamway.entities.Group;
import a3.emsi.theislamway.entities.Hizb;
import a3.emsi.theislamway.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class IslamWayInitServiceImpl implements IslamwayInitService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HizbRepository hizbRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void initUser() {
        for(int i=1;i<=60;i++){
           User user = new User();
           user.setNom("Nom"+i);
           user.setPrenom("Prenom"+i);
           user.setAlias("Alias"+i);
           user.setGroup(null);
           user.setAbsence(0);
           user.setMail("Mail"+i+"@gmail.com");
           user.setPassWord("1231");
           user.setCapLecture(1);
           user.setPoints(20);
           user.setGroup(groupRepository.findById(1L).get());
           user.setPrivilege("user");

           userRepository.save(user);
        }

    }

    @Override
    public void initHizb() {
        AtomicInteger count = new AtomicInteger(1);
        userRepository.findAll().forEach(user -> {
            Hizb hizb=new Hizb();
            hizb.setNo(count.getAndIncrement());
            hizb.setLu(false);
            hizb.setUser(user);
            hizbRepository.save(hizb);
        });
    }

    @Override
    public void initGroup() {
            Group group =new Group();
            group.setComplet(true);
            group.setNomGroupe("Salam");
            groupRepository.save(group);
    }
}
