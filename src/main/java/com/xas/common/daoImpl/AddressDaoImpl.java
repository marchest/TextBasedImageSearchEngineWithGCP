package com.xas.common.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xas.common.dao.AddressDao;
import com.xas.common.model.Address;
import com.xas.common.model.User;
@Repository("addressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {
	
	@PersistenceContext
	public EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public Address findAddress(Integer userId) {
	Query query =entityManager.createNativeQuery("Select u.* from useraddress u where u.userId= ?1",Address.class);
		
		query.setParameter(1, userId);
	
		Address ux=null;
		List<Address> u= query.getResultList();
		for (Address address : u) {
			 ux=address;
		}
			
		return ux;
	}

}
