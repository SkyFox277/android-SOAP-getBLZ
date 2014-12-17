package com.example.i.helloworld;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by i on 17.12.14.
 */
public class BankResponse implements KvmSerializable{
    private Details mDetails = new Details();

    @Override
    public Object getProperty(int index)
    {
        return mDetails;
    }

    @Override
    public int getPropertyCount()
    {
        return 1;
    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties,
                                PropertyInfo info)
    {
        info.name = "details";
        info.type = Details.class;
    }

    @Override
    public void setProperty(int index, Object value)
    {
        mDetails = (Details)value;
    }
}
