package com.metacube.usermanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

public class UserDao {
	private List<JSONObject> usersDetails;
	private Map<String, User> usersList;
	private static UserDao userDao;

	private UserDao() {
		init();
	}

	public static UserDao getInstance() {
		if (userDao == null) {
			synchronized (UserDao.class) {
				if (userDao == null) {
					userDao = new UserDao();
				}
			}
		}
		return userDao;
	}

	public void init() {
		usersList = new HashMap<String, User>();
		usersDetails = JsonFilehandling.read();
		for (JSONObject obj : usersDetails) {
			usersList.put(obj.get("id").toString(), new User(obj.get("id").toString(),obj.get("name").toString(), obj.get("profession").toString()));
		}
	}

	public String getAllUsers() {
		String s = "";
		Set<String> ids = usersList.keySet();
		for (String userId : ids) {
			s += "<b>UserId :</b> " + userId + "&nbsp<b> UserName : </b>" + usersList.get(userId).getName()
					+ "<b>&nbsp Profession :</b> " + usersList.get(userId).getProfession() + "<br><br>";
		}
		return s;

	}

	public User getUser(String id) {
		if(usersList.containsKey(id))
		return usersList.get(id);
		else
			return null;
	}

	public boolean addUser(User pUser) {
		boolean action = false;
			if (!usersList.containsKey(pUser.getId())) {
				action = true;
				usersList.put(pUser.getId(),pUser);
			}
			else{
			
			//saveUserList(userList);
		}
		return action;
	}

	public int updateUser(User pUser) {
		if(usersList.containsKey(pUser.getId())) {
			User user = usersList.get(pUser.getId());
			user.setName(pUser.getName());
			user.setProfession(pUser.getProfession());
			return 1;
		}
		return 0;
	}

	public int deleteUser(String id) {
		if(usersList.containsKey(id)) {
		usersList.remove(id);
		return 1;
		}
		return 0;
	}

	private void saveUserList(List<User> userList) {
		try {
			File file = new File("Users.txt");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}