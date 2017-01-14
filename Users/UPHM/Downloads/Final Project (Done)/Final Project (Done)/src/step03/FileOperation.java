package step03;

public class FileOperation {
    public static void main(String[] args) {
        FileUtil futil = new FileUtil();

        // open existing file
        String s1 = futil.openWriteFile("abc.txt");
        System.out.println(s1);
        
        // define text formatting
        String txtFormat = "%s,%d,%f%n";
        
        // add record 1
        String name1 = "Budi"; int age1 = 18; double salary1 = 2500000;
        String s2 = futil.addWriteRecord(txtFormat, name1, age1, salary1);
        System.out.println(s2);
        // add record 2
        String name2 = "Jack"; int age2 = 19; double salary2 = 3500000;
        String s3 = futil.addWriteRecord(txtFormat, name2,age2,salary2);
        System.out.println(s3);        
        // close opening file
        String s4 = futil.closeWriteFile();
        System.out.println(s4);                        
    }
}


