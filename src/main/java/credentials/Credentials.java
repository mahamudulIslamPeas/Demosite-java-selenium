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
    public String userName(){
        return "Admin";
    }
    public String password(){
        return "admin123";
    }
}
