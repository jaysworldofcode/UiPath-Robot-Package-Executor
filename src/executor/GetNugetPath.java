package executor;

import java.io.File;

public class GetNugetPath {
    
    String NuggetPath;
    
    public GetNugetPath(){
        File[] filesList = new File(".").listFiles();
        for(int count=0;count<filesList.length;count++){
            if(filesList[count].toString().contains("nupkg")){
                NuggetPath = filesList[count].toString();
                break;
            }
        }
    }
    public String getNugget(){
        return NuggetPath;
    }
}