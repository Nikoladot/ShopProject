package cubes.main.entity;

public class ChangePassword {
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	public ChangePassword() {
		
		
	}

	public ChangePassword(String oldPassword, String newPasswrod, String confirmPassword) {
		
		this.oldPassword = oldPassword;
		this.newPassword = newPasswrod;
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPasswrod) {
		this.newPassword = newPasswrod;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	

}
