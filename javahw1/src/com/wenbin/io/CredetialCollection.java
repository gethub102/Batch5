package com.wenbin.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CredetialCollection {
    private List<LongCredential> list;

    public CredetialCollection(List<LongCredential> list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }

    public void setList(List<LongCredential> list) {
        this.list = list;
    }

    public void serializeCredential() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("player.data")))
        {
            obj.writeObject(this.list);
            obj.flush();
            System.out.println("Serialized Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<LongCredential> deserializCredential() {

        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("player.data"))) {
            List<LongCredential> list_ret = (List<LongCredential>) obj.readObject();

            for (LongCredential item : list_ret) {
                System.out.println(item);
            }
            return list_ret;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        LongCredential obj1 = new LongCredential("U_name", "U_password");
        LongCredential obj2 = new LongCredential("Y_name", "Y_password");
        LongCredential obj3 = new LongCredential("I_name", "I_password");
        LongCredential obj4 = new LongCredential("O_name", "O_password");
        LongCredential obj5 = new LongCredential("P_name", "P_password");

        List<LongCredential> list = new ArrayList();
        list.addAll(Arrays.asList(obj1, obj2, obj3, obj4, obj5));

        CredetialCollection collection = new CredetialCollection(list);

        collection.serializeCredential();

        collection.deserializCredential();

    }
}
