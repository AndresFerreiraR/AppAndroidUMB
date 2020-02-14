package com.example.androidapp;

import android.os.Bundle;
import android.widget.EditText;

import com.example.androidapp.datos.entidades.AgendaDto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    EditText campoIdAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearAgenda();
        consultarAgenda();
    }

    public void crearAgenda() {
        AgendaDto agenda = new AgendaDto();
        agenda.setIdAgenda(3);
        agenda.setFecha("13 de Febrero");
        agenda.setAsunto("Un Asunto");
        agenda.setActividad("Actividad nueva");
        crearAgenda(agenda);
    }

    public void crearAgenda(AgendaDto agenda) {
        referencia
                .child("Agendas")
                .child(String.valueOf(agenda.getIdAgenda()))
                .setValue(agenda);
    }

    public void consultarAgenda() {
        referencia.child("Agendas").addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<AgendaDto> listaAgendas = new LinkedList();
                Iterator var3 = dataSnapshot.getChildren().iterator();
                while (var3.hasNext()) {
                    DataSnapshot entidad = (DataSnapshot) var3.next();
                    AgendaDto value = entidad.getValue(AgendaDto.class);
                    listaAgendas.add(value);
                }
                //Agregar a la pantalla

            }

            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
