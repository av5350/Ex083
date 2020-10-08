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
                            {"Bangkok", "Nonthaburi", "Pak Kret", "Hat Yai", "Surat Thani"}};

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
                            {}};

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