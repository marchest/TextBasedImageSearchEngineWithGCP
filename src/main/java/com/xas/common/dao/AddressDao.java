package com.xas.common.dao;

import com.xas.common.model.Address;

public interface AddressDao {

	public abstract Address findAddress(Integer userId);
}
