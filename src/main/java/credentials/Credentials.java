package credentials;
public class Credentials {
    public String baseUrl(String giveEnvironmentName){
        if ( giveEnvironmentName.equalsIgnoreCase("TestEnvironment") ){
            return "https://opensource-demo.orangehrmlive.com/web/index.php";
        }
        else {
            return "Invalid Environment";
        }
    }
    public String AppUrls(String module){
        if ( module.equalsIgnoreCase("dashboard") ){
            return "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        }
        else {
            return "Invalid module name";
        }
    }
    public String userName(){
        return "Admin";
    }
    public String password(){
        return "admin123";
    }
}
