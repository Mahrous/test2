package com.example.lasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.company.NetSDK.CB_fDisConnect;
import com.company.NetSDK.CB_fSearchDevicesCB;
import com.company.NetSDK.DEVICE_NET_INFO_EX;
import com.company.NetSDK.INetSDK;


public class MainActivity extends AppCompatActivity implements CB_fDisConnect, CB_fSearchDevicesCB {
EditText serialNumber , ip , port , deviceName , userName , password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serialNumber=findViewById(R.id.serial_number);
        ip=findViewById(R.id.ip);
        port=findViewById(R.id.port);
        deviceName=findViewById(R.id.d_name);
        userName=findViewById(R.id.user_name);
        password=findViewById(R.id.password);


        INetSDK.LoadLibrarys();
        INetSDK.Init(this);
        INetSDK.StartSearchDevices(this);


    }

    @Override
    public void invoke(long l, String s, int i) {

    }

    @Override
    public void invoke(DEVICE_NET_INFO_EX device_net_info_ex) {
        port.setText( device_net_info_ex.nPort + "");
        ip.setText( device_net_info_ex.iIPVersion + "");
    }
}