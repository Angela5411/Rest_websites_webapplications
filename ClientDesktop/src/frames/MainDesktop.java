
package frames;

public class MainDesktop {
    private Login login;
    private LoginAdmin loginA;
    
    public MainDesktop()
    {
        login =new Login(this);
        login.setVisible(true);
        loginA=new LoginAdmin(this);
        loginA.setVisible(false);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginAdmin getLoginA() {
        return loginA;
    }

    public void setLoginA(LoginAdmin loginA) {
        this.loginA = loginA;
    }
    public static void main(String[] args) {
            
        MainDesktop main=new MainDesktop();
}
} 