package com.example.homeworktwo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class TaskTwoActivity extends Activity {
    private RecyclerView busNumberRecuclerView;
    private RecyclerView vehicleTypeRecyclerView;
    private RecyclerView stopsRecyclerView;
    private RecyclerView fisrtLastStopsRecyclerView;
    private RecyclerView.Adapter busNumberAdapter;
    private RecyclerView.Adapter vehicleTypeAdapter;
    private RecyclerView.Adapter stopsAdapter;
    private RecyclerView.Adapter fisrtLastStopsAdapter;
    private RecyclerView.LayoutManager busNumberLayoutManager;
    private RecyclerView.LayoutManager vehicleLayoutManager;
    private RecyclerView.LayoutManager sropsLayoutManager;
    private RecyclerView.LayoutManager firstLastStopsLayoutManager;

    private ArrayList<String> busNumbersData;
    private ArrayList<String> vehicleTpeData;
    private ArrayList<String> firstLastStopsData;
    private ArrayList<String> stopsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_two);

        this.busNumbersData = new ArrayList<>();
        this.vehicleTpeData = new ArrayList<>();
        this.firstLastStopsData = new ArrayList<>();
        this.stopsData = new ArrayList<>();

        this.fillDatas();

        this.busNumberRecuclerView = (RecyclerView) this.findViewById(R.id.busNumberRecuclerView);
        this.vehicleTypeRecyclerView = (RecyclerView) this.findViewById(R.id.vehicleTypeRecyclerView);
        this.stopsRecyclerView = (RecyclerView) this.findViewById(R.id.stopsRecyclerView);
        this.fisrtLastStopsRecyclerView = (RecyclerView) this.findViewById(R.id.fisrtLastStopsRecyclerView);

        this.busNumberLayoutManager = new LinearLayoutManager(this);
        this.vehicleLayoutManager = new LinearLayoutManager(this);
        this.sropsLayoutManager = new LinearLayoutManager(this);
        this.firstLastStopsLayoutManager = new LinearLayoutManager(this);
        this.busNumberRecuclerView.setLayoutManager(this.busNumberLayoutManager);
        this.vehicleTypeRecyclerView.setLayoutManager(this.vehicleLayoutManager);
        this.stopsRecyclerView.setLayoutManager(this.sropsLayoutManager);
        this.fisrtLastStopsRecyclerView.setLayoutManager(this.firstLastStopsLayoutManager);

        this.busNumberAdapter = new RecycleViewAdapter(this.busNumbersData);
        this.busNumberRecuclerView.setAdapter(this.busNumberAdapter);

        this.vehicleTypeAdapter = new RecycleViewAdapter(this.vehicleTpeData);
        this.vehicleTypeRecyclerView.setAdapter(this.vehicleTypeAdapter);

        this.stopsAdapter = new RecycleViewAdapter(this.stopsData);
        this.stopsRecyclerView.setAdapter(this.stopsAdapter);

        this.fisrtLastStopsAdapter = new RecycleViewAdapter(this.firstLastStopsData);
        this.fisrtLastStopsRecyclerView.setAdapter(this.fisrtLastStopsAdapter);

        SofbusDecorationRecyclerView decorationRecyclerView = new SofbusDecorationRecyclerView();
        this.busNumberRecuclerView.addItemDecoration(decorationRecyclerView);
        this.vehicleTypeRecyclerView.addItemDecoration(decorationRecyclerView);
        this.stopsRecyclerView.addItemDecoration(decorationRecyclerView);
        this.fisrtLastStopsRecyclerView.addItemDecoration(decorationRecyclerView);

    }

    private void fillDatas(){
        for (int index = 0; index < 50; index++) {
            this.busNumbersData.add(index, String.valueOf(index));
        }

        this.vehicleTpeData.add("Автобусен");
        this.vehicleTpeData.add("Тролейбусен");
        this.vehicleTpeData.add("Трамваен");
        this.vehicleTpeData.add("Метро");

        this.firstLastStopsData.add("М.Сливница - М.Бизнес Парк");
        this.firstLastStopsData.add("М.Бизнес Парк . М. Сливница");
        this.firstLastStopsData.add("М.Джеймс Баучер - М.Летище София");
        this.firstLastStopsData.add("М.Летище София . М. Джеймс Баучер");

        this.stopsData.add("Младост 1");
        this.stopsData.add("Мусагеница");
        this.stopsData.add("Г.М. Димитров");
        this.stopsData.add("Жолио Кюри");
        this.stopsData.add("Стадион Васил Левски");
        this.stopsData.add("СУ Св. Климент Охридски");
        this.stopsData.add("Сердика");
        this.stopsData.add("Опълченска");
        this.stopsData.add("Константин Величков");
        this.stopsData.add("Вардар");
        this.stopsData.add("Западен парк");
        this.stopsData.add("Люлин");
        this.stopsData.add("Сливница");
        this.stopsData.add("Обеля");
        this.stopsData.add("Ломско Шосе");
        this.stopsData.add("Бели Дунав");
        this.stopsData.add("Надежда");
        this.stopsData.add("Хан Кубрат");
        this.stopsData.add("Княгиня Мария Луиза");
        this.stopsData.add("Централна ЖП Гара");
        this.stopsData.add("Лъвов Мост");
        this.stopsData.add("Сердика 2");
        this.stopsData.add("НДК");
        this.stopsData.add("Европейски Съюз");
        this.stopsData.add("Джеймс Баучър");
    }

}
