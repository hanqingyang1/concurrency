package com.hanqingyang.concurrent.chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName BalkingData
 * @Author 韩清阳
 * @Description //TODO
 * @Date 2019/11/8  9:03
 * @Version 1.0
 **/
public class BalkingData {

    private final String fileName;

    private String content;

    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save(){
        if(!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName()+" calls do save content" + content );
        try {
            Writer writer = new FileWriter(fileName,true);
            writer.write(content);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
