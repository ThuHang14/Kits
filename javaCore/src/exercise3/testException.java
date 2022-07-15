package exercise3;

public class testException {
    public static void main(String[] args) {
        try {
            System.out.println("start");
            int x = 1/0;
            System.out.println(x);

        } catch (Exception e) {
            System.out.println("catch");
        }finally {
            System.out.println("end");
        }
    }

}

class SampleException{
    public static void main(String args[]){
        try{
            throw new UserException(123);
        }
        catch(UserException e){
            System.out.println(" -- catch -- " + e) ;
        }
    }
}

class UserException extends Exception{
    int id1;
    UserException(int id2) {
        id1=id2;
    }
    public String toString(){
        return ("User id = "+id1 + " not found ") ;
    }
}