package service;

import dao.ContractDao;
import entity.ContractEntity;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
public class ContractService implements Serializable {

    @Inject
    private ContractDao contractDao;

    public List<ContractEntity> findAll() {
        return contractDao.findAll();
    }

    @Transactional
    public ContractEntity save(ContractEntity contract) {
        return contractDao.merge(contract);
    }

    @Transactional
    public void remove(ContractEntity contract) {
        contractDao.remove(contract);
    }

    @Transactional
    public void deleteAll(List<ContractEntity> listToDelete) {
        for (ContractEntity contract : listToDelete) {
            remove(contract);
        }
    }

    public Optional<ContractEntity> getById(long id) {
        return contractDao.getById(id);
    }

}
