package org.hov.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.dao.AdminDAO;
import org.hov.enums.AdminType;
import org.hov.model.Admin;
import org.hov.service.AdminService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class AdminTestCases {
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminDAO adminDAO;
	
	@Test
	//@Ignore
	public void addAdmin1() {
		Admin admin = new Admin();
		admin.setAdminid(UUID.fromString("12344654"));
		admin.setEmail("robin12@gmail.com");
		admin.setFirstName("Admin5 First Name");
		admin.setLastName("Admin5 Last Name");
		admin.setActive(true);
		admin.setAdminType(AdminType.FUND_ADMIN);
		
		assertTrue(adminService.addAdmin(admin));
	}
	
	@Test
	@Ignore
	public void updateAdmin() {
		Admin admin = adminService.getAdminById(UUID.fromString("12344654"));
		admin.setLastName("Big Smoke");
		
		assertTrue(adminService.updateAdmin(admin));
	}
	
	@Test
	@Ignore
	public void deleteAdmin(){
		assertTrue(adminDAO.deleteAdmin(UUID.fromString("12344654")));
	}
	
	@Test
	@Ignore
	public void getAdminbyId() {
		Admin admin = adminService.getAdminById(UUID.fromString("12344654"));
		System.out.println("Admin Name: "+ admin.getFirstName());
		
		assertNotNull(adminService.getAdminById(UUID.fromString("12344654")));
	}
	
	@Test
	@Ignore
	public void getAllAdmins() {
		List<Admin> adminList = adminService.getAllAdmins();
		for(Admin a:adminList) {
			System.out.println("Admin Name: "+ a.getFirstName());
		}
		assertTrue(true);
	}
	
	@Test
	@Ignore
	public void toggleSuspend() {
		assertTrue(adminService.toggleSuspend(UUID.fromString("12344654")));
	}
}