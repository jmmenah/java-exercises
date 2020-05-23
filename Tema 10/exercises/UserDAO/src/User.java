public class User {

    private int id;
    private String name;
    private String pass;
    private int age;

    public User(){

    }

    public User(String name,String pass,int age){
        setName(name);
        setPass(pass);
        setAge(age);
    }

    public User(int id,String name,String pass,int age){
        setId(id);
        setName(name);
        setPass(pass);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "User [id="+getId()+", name="+getName()+", pass="+getPass()+", age="+getAge()+"]";
    }
}
