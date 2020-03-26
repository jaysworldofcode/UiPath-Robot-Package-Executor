package executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import sun.awt.shell.ShellFolder;

public class Executor {
    CreateLoadingScreen progress_loader;
    String nugget = new GetNugetPath().getNugget();
    String outputPath = ShellFolder.get("fileChooserDefaultFolder").toString()+
                    "/Excutor";
    String robot_path = "C:\\Program Files (x86)\\UiPath\\Studio\\UiRobot.exe";
    public Executor(){
        progress_loader = new CreateLoadingScreen();
        progress_loader.setVisible(true);
        
        if(nugget == null){
            System.exit(0);
        }
        
        SetWait();
        CreateDumpDirectoryFile();
        new CopyFile(new File(nugget),new File(outputPath+"/runnable.zip"));
        new ExtractFile(
                outputPath+"/runnable.zip",
                outputPath
        );
        progress_loader.setVisible(false);
        RunCommandToCMD();
        new DeletePath(outputPath);
        System.exit(0);
    }
    void RunCommandToCMD(){
        try{
        Process process = Runtime.getRuntime().exec(
                "\""+"C:\\Program Files (x86)\\UiPath\\Studio\\UiRobot.exe"+"\""+" -file "+"\""+
                outputPath+"\\lib\\net45\\Main.xaml"+"\""
        );
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(process.getInputStream()));
        reader.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    void CreateDumpDirectoryFile(){
        try{
            Path path = Paths.get(outputPath);
            Files.createDirectories(path);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    void SetWait(){
        int timeToWait = 2; //second
        try {
            for (int i=0; i<timeToWait ; i++) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        //new Executor();
        File dir = new File("C:\\Users\\RPA-06\\Documents\\Excutor\\runnable.zip");
        dir.delete();
    }
}