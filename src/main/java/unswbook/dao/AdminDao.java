package unswbook.dao;

import unswbook.model.Admin;

public interface AdminDao {

	boolean validAdmin(Admin admin);
	
	Admin findAdminByUsername(String username);
}
