package com.example.jdrod.essentialapp.Objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by JdRod on 21/02/2018.
 */

public class Device {

    private String manufacturer;
    private String location;

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        String[] lines = xml.split(">");
        ArrayList<String> folderNames = new ArrayList<>();
        for (String line: lines
             ) {
            if(line.contains("folder name=")){

                line = line.replaceAll("<folder name=" ,"").replaceAll(">","").
                        replaceAll("<","").replaceAll("/","").
                        replaceAll("\\\\","").replaceAll("\"", "");;
                if((line.charAt(0)+"").equals(startingLetter+"")){
                    folderNames.add(line);
                }

            }

        }

        Collection<String> collection = folderNames;

        return collection;

    }
    String path;
    public void cd(String newPath) {
        String temp;

        if(newPath.startsWith("..")){
            if(path.contains(newPath.charAt(2)+"")){
                do{
                    path = path.substring(0,path.length()-2);

                }while (path.contains(newPath.charAt(2)+""));

            }
            newPath = newPath.replace(".","");
            newPath = path.substring(0,path.length()-2)+newPath;
            this.path = newPath;
        }else if(newPath.startsWith("/")){
            if(newPath.length()==1){
                this.path = "/";
            }else{
                this.path = path+newPath;
            }
         }

        }




}
