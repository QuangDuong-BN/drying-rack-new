package com.example.appgianphoi;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView textViewAnhSang = (TextView) findViewById(R.id.textViewAnhSang);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        mDatabase.child("cheDoString").child("cheDoString").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView textViewMode = (TextView) findViewById(R.id.textViewMode);
                String mode = snapshot.getValue().toString();
                if(mode.equals("mot")){
                    textViewMode.setText("Mode 1");
                }
                if(mode.equals("hai")){
                    textViewMode.setText("Mode 2");
                }
                if(mode.equals("ba")){
                    textViewMode.setText("Mode 3");
                }
                if(mode.equals("bon")){
                    textViewMode.setText("Mode 4");
                }
                if(mode.equals("up")){
                    textViewMode.setText("Up");
                }
                if(mode.equals("down")){
                    textViewMode.setText("Down");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //
        String giaTriAnhSang;


        // hien thi trang thai mua voi khong mua

        mDatabase.child("giaTriMua").child("giaTriMua").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                ImageView imageView = (ImageView) findViewById(R.id.imageSunOrRain);
                TextView textViewTrangThaiMua = (TextView) findViewById(R.id.textViewTrangThaiMua);

                String giaTriSunOrRain = snapshot.getValue().toString();
                if (giaTriSunOrRain.equals("Mua")) {
                    textViewTrangThaiMua.setTextColor(getResources().getColor(R.color.Rain));
                    textViewTrangThaiMua.setText("Rain");
                    imageView.setImageResource(R.drawable.rain);
                } else {

                    textViewTrangThaiMua.setTextColor(getResources().getColor(R.color.Sunny));
                    textViewTrangThaiMua.setText("Sunny");
                    imageView.setImageResource(R.drawable.sang_khongmua);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //  hien thi nhiet do
        mDatabase.child("giaTriAnhNhietDo").child("giaTriAnhNhietDo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView textViewNhietDo = (TextView) findViewById(R.id.textViewNhietDo);
                Object nhietDo = snapshot.getValue();
                textViewNhietDo.setText(nhietDo.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        // hien thi do am
        mDatabase.child("giaTriDoAm").child("giaTriDoAm").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView textViewDoAm = (TextView) findViewById(R.id.textViewDoAm);
                Object nhietDo = snapshot.getValue();
                textViewDoAm.setText(nhietDo.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    public void onClickUp(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("up");
    }

    public void onClickDown(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("down");
    }
    public void onClickMode1(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("mot");
    }

    public void onClickMode2(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("hai");
    }

    public void onClickMode3(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("ba");
    }
    public void onClickMode4(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("cheDoString").child("cheDoString").setValue("bon");
    }

}