package com.wenbin.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PlayerIII implements Externalizable {
    String name;
    int age;
    double salary;
    String debt;

    public PlayerIII(String name, int age, double salary, String debt) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.debt = debt;
    }

    @Override
    public String toString() {
        return name + " : " + age + " : " + salary + " : " + debt;
    }

    public PlayerIII() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeInt(age);
        out.writeDouble(salary);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        age = in.readInt();
        salary = in.readDouble();
    }


}
