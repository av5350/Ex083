package com.example.ex083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        AdapterView.OnItemClickListener {
    Spinner continents, countries;

    ListView cities;

    TextView residentsNum, cityArea;

    int countriesPos, citiesPos;

    String[][] countriesArr = {{"Nigeria", "Ethiopia", "Egypt", "Tanzania", "Kenya", "Uganda", "Algeria"},
            {"China", "India", "Mongolia", "Pakistan", "Myanmar", "Japan", "Thailand"},
            {"Romania", "Ukraine", "Sweden", "Norway", "Germany", "Finland", "Poland"},
            {"Venezuela", "Brazil", "Bolivia", "Chile", "Colombia", "Peru", "Suriname"}};

    String[][] citiesArr = {{"Lagos", "Kano", "Ibadan", "Benin City", "Port Harcourt"},
                            {"Addis Ababa", "Mekelle", "Gondar", "Bahir Dar", "Hawassa"},
                            {"Cairo", "Alexandria", "Luxor", "Giza", "Suez"},
                            {"Dar es Salaam", "Mwanza", "Dodoma", "Morogoro", "Tanga"},
                            {"Nairobi", "Mombasa", "Kisumu", "Ruiru", "Athi River"},
                            {"Kampala", "Kira", "Mukono", "Mityana", "Entebbe"},
                            {"Algiers", "Oran", "Constantine", "Batna", "Annaba"},
                            {"Hong Kong", "Macau", "Yuci", "Zhangqiu", "Zhuji"},
                            {"Mumbai", "Delhi", "Bangalore", "Hyderabad", "Ahmedabad"},
                            {"Ulaanbaatar", "Erdenet", "Darkhan", "Choibalsan", "Nalaikh"},
                            {"Karachi", "Lahore", "Faisalabad", "Rawalpindi", "Gujranwala"},
                            {"Yangon", "Mandalay", "Naypyidaw", "Bago", "Chin"},
                            {"Nagoya", "Toyohashi", "Okazaki", "Ichinomiya", "Seto"},
                            {"Bangkok", "Nonthaburi", "Pak Kret", "Hat Yai", "Surat Thani"},
                            {"Bucharest", "Timișoara", "Constanța", "Brașov", "Oradea"},
                            {"Kyiv", "Kharkiv", "Odessa", "Dnipro", "Donetsk"},
                            {"Arboga", "Arvika", "Askersund", "Avesta", "Stockholm"},
                            {"Oslo", "Bergen", "Trondheim", "Stavanger", "Skien"},
                            {"Berlin", "Hamburg", "Munich", "Cologne", "Stuttgart"},
                            {"Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu"},
                            {"Warsaw", "Krakow", "Wroclaw", "Poznan", "Szczecin"},
                            {"Caracas", "Maracaibo", "Valencia", "Maracay", "Maturín"},
                            {"Sao Paulo", "Brasilia", "Salvador", "Fortaleza", "Manaus"},
                            {"La Paz", "Cochabamba", "Oruro", "Sucre", "Potosi"},
                            {"Santiago", "Valparaiso", "Arica", "Concepcion", "Rancagua"},
                            {"Bogota", "Leticia", "Puerto Carreno", "Cumaribo", "La Primavera"},
                            {"Lima", "Arequipa", "Trujillo", "Chiclayo", "Piura"},
                            {"Albina", "Paramaribo", "Lelydorp", "Moengo", "Wageningen"}};

    String[][] infoArr = {  // Africa
                            {"14,368,332", "1,171"}, {"3,999,050", "499"},
                            {"3,551,961", "3,080"}, {"1,727,169", "1,204"},
                            {"3,020,232", "369"},
                            {"4,793,699", "527"}, {"310,436", "24.44"},
                            {"299,969", "192.3"}, {"750,991", "28"},
                            {"315,267", "50"},
                            {"20,900,604", "3,085"}, {"5,280,664", "2,679"},
                            {"506,588", "416"}, {"2,443,203", "1,580"},
                            {"744,189", "250.4"},
                            {"2,698,652", "1,590"}, {"436,801", "1,325"},
                            {"180,541", "2,576"}, {"250,902", "360"},
                            {"224,876", "536"},
                            {"2,750,547", "696"}, {"799,668", "219.9"},
                            {"216,479", "417"}, {"490,120", "292"},
                            {"81,302", "693"},
                            {"1,353,189", "189"}, {"317,157", "98.83"},
                            {"161,996", "31.4"}, {"48,002", "21"},
                            {"69,958", "56.2"},
                            {"3,915,811", "363"}, {"803,329", "2,121"},
                            {"464,219", "2,288"}, {"290,645", "85"},
                            {"257,359", "49"},
                            // Asia
                            {"7,500,700", "2,755"}, {"696,100", "115.3"},
                            {"560,000", "1,327"}, {"1,064,210", "1,721.29"},
                            {"1,157,938", "2,311.41"},
                            {"12,478,447", "603"}, {"16,787,941", "1,484"},
                            {"8,443,675", "709"}, {"6,809,970", "625"},
                            {"5,633,927", "464.16"},
                            {"1,444,669", "4,704.4"}, {"97,814", "208"},
                            {"83,883", "103"}, {"44,835", "281"},
                            {"28,152", "687.6"},
                            {"14,910,352", "3,780"}, {"11,126,285", "1,772"},
                            {"3,203,846", "1,300"}, {"2,098,231", "259"},
                            {"2,027,001", "240"},
                            {"5,160,512", "598.75"}, {"1,726,889", "163.84"},
                            {"924,608", "7,054.37"}, {"4,934,428", "39,404"},
                            {"516,752", "36,019"},
                            {"2,327,557", "326.45"}, {"377,453", "261.86"},
                            {"386,999", "387.20"}, {"379,654", "113.82"},
                            {"127,659", "111.40"},
                            {"8,305,218", "1,568.737"}, {"254,375", "38.90"},
                            {"190,272", "36.04"}, {"156,802", "21"},
                            {"132,040", "68.97"},
                            // Europe
                            {"1,803,247", "228"}, {"319,279", "130.5"},
                            {"283,872", "124.89"}, {"253,200", "267.32"},
                            {"196,367", "115.56"},
                            {"2,950,800", "839"}, {"2,139,036", "350"},
                            {"1,016,515", "162.42"}, {"998,103", "409,718"},
                            {"929,063", "358"},
                            {"10,330", "9.50"}, {"14,244", "10.62"},
                            {"3,887", "2.7802"}, {"11,949", "13.91"},
                            {"975,904", "188"},
                            {"693,491", "480.75"}, {"283,929", "464.71"},
                            {"199,039", "321.81"}, {"135,118", "71.35"},
                            {"54,887", "779"},
                            {"3,769,495", "891.1"}, {"1,899,160", "755.22"},
                            {"1,484,226", "310.43"}, {"1,087,863", "405.15"},
                            {"635,911", "207.36"},
                            {"656,229", "715.48"}, {"291,439", "528.03"},
                            {"239,076", "689.59"}, {"235,911", "240.35"},
                            {"206,001", "3,817.52"},
                            {"1,790,658", "517.24"}, {"779,115", "326.8"},
                            {"643,782", "292.92"}, {"534,813", "261.85"},
                            {"401,907", "301"},
                            // America
                            {"2,245,744", "433"}, {"1,200,000", "1,393"},
                            {"832,409", "623"}, {"955,362", "911.57"},
                            {"472,909", "13,352"},
                            {"12,176,866", "1,521.11"}, {"3,039,444", "5,802"},
                            {"2,857,329", "693"}, {"2,643,247", "314.93"},
                            {"2,182,763", "11,401.092"},
                            {"766,468", "472"}, {"630,587", "170"},
                            {"264,683", "1,633"}, {"300,000", "1,768"},
                            {"174,973", "118.218"},
                            {"5,220,161", "641"}, {"284,630", "401.6"},
                            {"222,619", "4,799.4"}, {"223,574", "222"},
                            {"232,211", "260.3"},
                            {"7,412,566", "1,587"}, {"48,144", "5,968"},
                            {"20,936", "12,409"}, {"23,990", "65.193"},
                            {"9,690", "22,159"},
                            {"8,838,102", "2,672.3"}, {"1,008,290", "69"},
                            {"919,899", "1,100"}, {"552,508", "174.46"},
                            {"484,475", "621.2"},
                            {"5,247", "397"}, {"240,924", "182"},
                            {"18,663", "149"}, {"10,834", "1,117"},
                            {"2,937", "1,613"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continents = (Spinner) findViewById(R.id.continents);
        countries = (Spinner) findViewById(R.id.countries);
        cities = (ListView) findViewById(R.id.cities);
        residentsNum = (TextView) findViewById(R.id.residentsNum);
        cityArea = (TextView) findViewById(R.id.cityArea);

        continents.setOnItemSelectedListener(this);
        countries.setOnItemSelectedListener(this);

        cities.setOnItemClickListener(this);
        cities.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> continentsAdp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.continentsArr));
        continents.setAdapter(continentsAdp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.continents) {
            if (position != 0) {
                countries.setVisibility(View.VISIBLE);
                cities.setVisibility(View.VISIBLE);
                countriesPos = position - 1;
                ArrayAdapter<String> countriesAdp = new ArrayAdapter<String>(this,
                        R.layout.support_simple_spinner_dropdown_item, countriesArr[countriesPos]);
                countries.setAdapter(countriesAdp);
            }
            else {
                countries.setVisibility(View.GONE);
                cities.setVisibility(View.GONE);
            }
        }
        else {
            citiesPos = position + (countriesPos * 7);
            ArrayAdapter<String> citiesAdp = new ArrayAdapter<String>(this,
                    R.layout.support_simple_spinner_dropdown_item, citiesArr[citiesPos]);
            cities.setAdapter(citiesAdp);
        }
        residentsNum.setText("Num of residents: ");
        cityArea.setText("City area: ");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        residentsNum.setText("Num of residents: " + infoArr[5 * citiesPos + position][0]);
        cityArea.setText("City area: " + infoArr[5 * citiesPos + position][1] + " km^2");
    }
}