package com.meetpatel.turbotranslator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Spinner spinner1,spinner2;
    TextInputEditText text ;
    TextInputLayout textInputLayout;

    TextView translatedText;
    Button btnTranslate;
    ArrayList<String> SL = new ArrayList<>();

    String lnInputCode , lnOutputCode ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning Variables

        constraintLayout = findViewById(R.id.constraint);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        btnTranslate = findViewById(R.id.btnTranslate);
        text = findViewById(R.id.textfield);
        textInputLayout = findViewById(R.id.t1);


        translatedText=findViewById(R.id.translatedText);



        constraintLayout.setOnClickListener(null);

        // for setting material text input layout
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Objects.requireNonNull(text.getText()).toString().isEmpty()) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("Please Enter Your Text :");
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // for setting warning from starting

        text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (Objects.requireNonNull(text.getText()).toString().isEmpty()) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("Please Enter your Text :");
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }
        });
        //Initialize Arraylist For spinner

        SL.add("Please Select Your Language");
        SL.add("Afrikaans");
        SL.add("Albanian");
        SL.add("Amharic");
        SL.add("Arabic");
        SL.add("Armenian");
        SL.add("Azerbaijani");
        SL.add("Basque");
        SL.add("Belarusian");
        SL.add("Bengali");
        SL.add("Bosnian");
        SL.add("Bulgarian");
        SL.add("Burmese");
        SL.add("Catalan");
        SL.add("Chinese");
        SL.add("Chinese(Simplifide)");
        SL.add("Chinese (Traditional)");
        SL.add("Corsican");
        SL.add("Croatian");
        SL.add("Czech");
        SL.add("Danish");
        SL.add("Dutch");
        SL.add("English");
        SL.add("Esperanto");
        SL.add("Estonian");
        SL.add("Finnish");
        SL.add("French");
        SL.add("Galician");
        SL.add("Georgian");
        SL.add("German");
        SL.add("Greek");
        SL.add("Gujarati");
        SL.add("Haitian Creole");
        SL.add("Hausa");
        SL.add("Hebrew");
        SL.add("Hindi");
        SL.add("Hungarian");
        SL.add("Icelandic");
        SL.add("Igbo");
        SL.add("Indonesian");
        SL.add("Irish");
        SL.add("Italian");
        SL.add("Japanese");
        SL.add("Javanese");
        SL.add("Kannada");
        SL.add("Kazakh");
        SL.add("Khmer");
        SL.add("Kinyarwanda (Rwanda)");
        SL.add("Korean");
        SL.add("Kurdish");
        SL.add("Lao");
        SL.add("Latin");
        SL.add("Latvian (Lettish)");
        SL.add("Lithuanian");
        SL.add("Luxembourgish");
        SL.add("Macedonian");
        SL.add("Malagasy");
        SL.add("Malay");
        SL.add("Malayalam");
        SL.add("Maltese");
        SL.add("Maori");
        SL.add("Marathi");
        SL.add("Mongolian");
        SL.add("Nepali");
        SL.add("Norwegian");
        SL.add("Oriya");
        SL.add("Persian (Farsi)");
        SL.add("Polish");
        SL.add("Portuguese");
        SL.add("Punjabi (Eastern)");
        SL.add("Romanian");
        SL.add("Russian");
        SL.add("Samoan");
        SL.add("Serbian");
        SL.add("Sesotho");
        SL.add("Shona");
        SL.add("Sindhi");
        SL.add("Sinhalese");
        SL.add("Slovak");
        SL.add("Slovenian");
        SL.add("Spanish");
        SL.add("Sundanese");
        SL.add("Swedish");
        SL.add("Swahili (Kiswahili)");
        SL.add("Tajik");
        SL.add("Tatar");
        SL.add("Tamil");
        SL.add("Telugu");
        SL.add("Thai");
        SL.add("Turkish");
        SL.add("Turkmen");
        SL.add("Uyghur");
        SL.add("Ukrainian");
        SL.add("Urdu");
        SL.add("Uzbek");
        SL.add("Vietnamese");
        SL.add("Welsh");
        SL.add("Western Frisian");
        SL.add("Xhosa");
        SL.add("Yiddish");
        SL.add("Yoruba");
        SL.add("Zulu");


        //Set Adapter

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,SL);
        spinner1.setAdapter(arrayAdapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //Display Toast

                    Toast.makeText(MainActivity.this, "Please Select your Language", Toast.LENGTH_SHORT).show();
                }

                String lanSelected = parent.getItemAtPosition(position).toString();
                if (position != 0) {
                    Toast.makeText(MainActivity.this, "Your Input language is "+lanSelected, Toast.LENGTH_SHORT).show();
                }



                if (lanSelected.equals("Abkhazian")){
                    lnInputCode="ab";
                }
                if (lanSelected.equals("Afar")){
                    lnInputCode="aa";
                }
                if (lanSelected.equals("Afrikaans")){
                    lnInputCode="af";
                }
                if (lanSelected.equals("Akan")){
                    lnInputCode="ak";
                }
                if (lanSelected.equals("Albanian")){
                    lnInputCode="sq";
                }
                if (lanSelected.equals("Amharic")){
                    lnInputCode="am";
                }
                if (lanSelected.equals("Arabic")){
                    lnInputCode="ar";
                }
                if (lanSelected.equals("Aragonese")){
                    lnInputCode="an";
                }
                if (lanSelected.equals("Armenian")){
                    lnInputCode="hy";
                }
                if (lanSelected.equals("Assamese")){
                    lnInputCode="as";
                }
                if (lanSelected.equals("Avaric")){
                    lnInputCode="av";
                }
                if (lanSelected.equals("Avestan")){
                    lnInputCode="ae";
                }
                if (lanSelected.equals("Aymara")){
                    lnInputCode="ay";
                }
                if (lanSelected.equals("Bambara")){
                    lnInputCode="bm";
                }
                if (lanSelected.equals("Bambara")){
                    lnInputCode="ba";
                }
                if (lanSelected.equals("Basque")){
                    lnInputCode="eu";
                }
                if (lanSelected.equals("Belarusian")){
                    lnInputCode="be";
                }
                if (lanSelected.equals("Bengali")){
                    lnInputCode="bn";
                }
                if (lanSelected.equals("Bihari")){
                    lnInputCode="bh";
                }
                if (lanSelected.equals("Bislama")){
                    lnInputCode="bi";
                }
                if (lanSelected.equals("Bosnian")){
                    lnInputCode="bs";
                }
                if (lanSelected.equals("Breton")){
                    lnInputCode="br";
                }
                if (lanSelected.equals("Bulgarian")){
                    lnInputCode="bg";
                }
                if (lanSelected.equals("Burmese")){
                    lnInputCode="my";
                }
                if (lanSelected.equals("Catalan")){
                    lnInputCode="ca";
                }
                if (lanSelected.equals("Chamorro")){
                    lnInputCode="ch";
                }
                if (lanSelected.equals("Chechen")){
                    lnInputCode="ce";
                }
                if (lanSelected.equals("Chichewa, Chewa, Nyanja")){
                    lnInputCode="ny";
                }
                if (lanSelected.equals("Chinese")){
                    lnInputCode="zh";
                }
                if (lanSelected.equals("Chinese (Simplified)")){
                    lnInputCode="zh-Hans";
                }
                if (lanSelected.equals("Chinese (Traditional)")){
                    lnInputCode="zh-Hant";
                }
                if (lanSelected.equals("Chuvash")){
                    lnInputCode="cv";
                }
                if (lanSelected.equals("Cornish")){
                    lnInputCode="kw";
                }
                if (lanSelected.equals("Corsican")){
                    lnInputCode="co";
                }
                if (lanSelected.equals("Cree")){
                    lnInputCode="cr";
                }
                if (lanSelected.equals("Croatian")){
                    lnInputCode="hr";
                }
                if (lanSelected.equals("Czech")){
                    lnInputCode="cs";
                }
                if (lanSelected.equals("Danish")){
                    lnInputCode="da";
                }
                if (lanSelected.equals("Divehi, Dhivehi, Maldivian")){
                    lnInputCode="dv";
                }
                if (lanSelected.equals("Dutch")){
                    lnInputCode="nl";
                }
                if (lanSelected.equals("Dzongkha")){
                    lnInputCode="dz";
                }
                if (lanSelected.equals("English")){
                    lnInputCode="en";
                }
                if (lanSelected.equals("Esperanto")){
                    lnInputCode="eo";
                }
                if (lanSelected.equals("Estonian")){
                    lnInputCode="et";
                }
                if (lanSelected.equals("Ewe")){
                    lnInputCode="ee";
                }
                if (lanSelected.equals("Faroese")){
                    lnInputCode="fo";
                }
                if (lanSelected.equals("Fijian")){
                    lnInputCode="fj";
                }
                if (lanSelected.equals("Finnish")){
                    lnInputCode="fi";
                }
                if (lanSelected.equals("French")){
                    lnInputCode="fr";
                }
                if (lanSelected.equals("Fula, Fulah, Pulaar, Pular")){
                    lnInputCode="ff";
                }
                if (lanSelected.equals("Galician")){
                    lnInputCode="gl";
                }
                if (lanSelected.equals("Gaelic (Scottish)")){
                    lnInputCode="gd";
                }
                if (lanSelected.equals("Gaelic (Manx)")){
                    lnInputCode="gv";
                }
                if (lanSelected.equals("Georgian")){
                    lnInputCode="ka";
                }
                if (lanSelected.equals("German")){
                    lnInputCode="de";
                }
                if (lanSelected.equals("Greek")){
                    lnInputCode="el";
                }
                if (lanSelected.equals("Greenlandic")){
                    lnInputCode="kl";
                }
                if (lanSelected.equals("Guarani")){
                    lnInputCode="gn";
                }
                if (lanSelected.equals("Gujarati")){
                    lnInputCode="gu";
                }
                if (lanSelected.equals("Haitian Creole")){
                    lnInputCode="ht";
                }
                if (lanSelected.equals("Hausa")){
                    lnInputCode="ha";
                }
                if (lanSelected.equals("Hebrew")){
                    lnInputCode="he";
                }
                if (lanSelected.equals("Herero")){
                    lnInputCode="hz";
                }
                if (lanSelected.equals("Hindi")){
                    lnInputCode="hi";
                }
                if (lanSelected.equals("Hiri Motu")){
                    lnInputCode="ho";
                }
                if (lanSelected.equals("Hungarian")){
                    lnInputCode="hu";
                }
                if (lanSelected.equals("Icelandic")){
                    lnInputCode="is";
                }
                if (lanSelected.equals("Ido")){
                    lnInputCode="io";
                }
                if (lanSelected.equals("Igbo")){
                    lnInputCode="ig";
                }
                if (lanSelected.equals("Indonesian")){
                    lnInputCode="id";
                }
                if (lanSelected.equals("Interlingua")){
                    lnInputCode="ia";
                }
                if (lanSelected.equals("Interlingue")){
                    lnInputCode="ie";
                }
                if (lanSelected.equals("Inuktitut")){
                    lnInputCode="iu";
                }

                if (lanSelected.equals("Inupiak")){
                    lnInputCode="ik";
                }

                if (lanSelected.equals("Irish")){
                    lnInputCode="ga";
                }

                if (lanSelected.equals("Italian")){
                    lnInputCode="it";
                }

                if (lanSelected.equals("Japanese")){
                    lnInputCode="ja";
                }

                if (lanSelected.equals("Javanese")){
                    lnInputCode="jv";
                }

                if (lanSelected.equals("Kalaallisut, Greenlandic")){
                    lnInputCode="kl";
                }

                if (lanSelected.equals("Kannada")){
                    lnInputCode="kn";
                }

                if (lanSelected.equals("Kanuri")){
                    lnInputCode="kr";
                }

                if (lanSelected.equals("Kashmiri")){
                    lnInputCode="ks";
                }

                if (lanSelected.equals("Kazakh")){
                    lnInputCode="kk";
                }

                if (lanSelected.equals("Khmer")){
                    lnInputCode="km";
                }

                if (lanSelected.equals("Kikuyu")){
                    lnInputCode="ki";
                }

                if (lanSelected.equals("Kinyarwanda (Rwanda)")){
                    lnInputCode="rw";
                }

                if (lanSelected.equals("Kirundi")){
                    lnInputCode="rn";
                }

                if (lanSelected.equals("Kyrgyz")){
                    lnInputCode="ky";
                }

                if (lanSelected.equals("Komi")){
                    lnInputCode="kv";
                }

                if (lanSelected.equals("Kongo")){
                    lnInputCode="kg";
                }

                if (lanSelected.equals("Korean")){
                    lnInputCode="ko";
                }

                if (lanSelected.equals("Kurdish")){
                    lnInputCode="ku";
                }

                if (lanSelected.equals("Kwanyama")){
                    lnInputCode="kj";
                }

                if (lanSelected.equals("Lao")){
                    lnInputCode="lo";
                }

                if (lanSelected.equals("Latin")){
                    lnInputCode="la";
                }

                if (lanSelected.equals("Latvian (Lettish)")){
                    lnInputCode="lv";
                }

                if (lanSelected.equals("Limburgish ( Limburger)")){
                    lnInputCode="li";
                }

                if (lanSelected.equals("Lingala")){
                    lnInputCode="ln";
                }

                if (lanSelected.equals("Lithuanian")){
                    lnInputCode="lt";
                }

                if (lanSelected.equals("Luga-Katanga")){
                    lnInputCode="lu";
                }

                if (lanSelected.equals("Luganda, Ganda")){
                    lnInputCode="lg";
                }

                if (lanSelected.equals("Luxembourgish")){
                    lnInputCode="lb";
                }

                if (lanSelected.equals("Manx")){
                    lnInputCode="gv";
                }

                if (lanSelected.equals("Macedonian")){
                    lnInputCode="mk";
                }

                if (lanSelected.equals("Malagasy")){
                    lnInputCode="mg";
                }

                if (lanSelected.equals("Malay")){
                    lnInputCode="ms";
                }

                if (lanSelected.equals("Malayalam")){
                    lnInputCode="ml";
                }

                if (lanSelected.equals("Maltese")){
                    lnInputCode="mt";
                }

                if (lanSelected.equals("Maori")){
                    lnInputCode="mi";
                }

                if (lanSelected.equals("Marathi")){
                    lnInputCode="mr";
                }

                if (lanSelected.equals("Marshallese")){
                    lnInputCode="mh";
                }

                if (lanSelected.equals("Moldavian")){
                    lnInputCode="mo";
                }

                if (lanSelected.equals("Mongolian")){
                    lnInputCode="mn";
                }

                if (lanSelected.equals("Nauru")){
                    lnInputCode="na";
                }

                if (lanSelected.equals("Navajo")){
                    lnInputCode="nv";
                }

                if (lanSelected.equals("Ndonga")){
                    lnInputCode="ng";
                }

                if (lanSelected.equals("Northern Ndebele")){
                    lnInputCode="nd";
                }

                if (lanSelected.equals("Nepali")){
                    lnInputCode="ne";
                }

                if (lanSelected.equals("Norwegian")){
                    lnInputCode="no";
                }

                if (lanSelected.equals("Norwegian bokmål")){
                    lnInputCode="nb";
                }

                if (lanSelected.equals("Norwegian nynorsk")){
                    lnInputCode="nn";
                }
                if (lanSelected.equals("Nuosu")){
                    lnInputCode="ii";
                }
                if (lanSelected.equals("Occitan")){
                    lnInputCode="oc";
                }
                if (lanSelected.equals("Ojibwe")){
                    lnInputCode="oj";
                }
                if (lanSelected.equals("Old Church Slavonic, Old Bulgarian")){
                    lnInputCode="cu";
                }
                if (lanSelected.equals("Oriya")){
                    lnInputCode="or";
                }
                if (lanSelected.equals("Oromo (Afaan Oromo)")){
                    lnInputCode="om";
                }
                if (lanSelected.equals("Ossetian")){
                    lnInputCode="os";
                }
                if (lanSelected.equals("Pāli")){
                    lnInputCode="pi";
                }
                if (lanSelected.equals("Pashto, Pushto")){
                    lnInputCode="ps";
                }
                if (lanSelected.equals("Persian (Farsi)")){
                    lnInputCode="fa";
                }
                if (lanSelected.equals("Polish")){
                    lnInputCode="pl";
                }
                if (lanSelected.equals("Portuguese")){
                    lnInputCode="pt";
                }
                if (lanSelected.equals("Punjabi (Eastern)")){
                    lnInputCode="pa";
                }
                if (lanSelected.equals("Quechua")){
                    lnInputCode="qu";
                }
                if (lanSelected.equals("Romansh")){
                    lnInputCode="rm";
                }
                if (lanSelected.equals("Romanian")){
                    lnInputCode="ro";
                }
                if (lanSelected.equals("Russian")){
                    lnInputCode="ru";
                }
                if (lanSelected.equals("Sami")){
                    lnInputCode="se";
                }
                if (lanSelected.equals("Samoan")){
                    lnInputCode="sm";
                }
                if (lanSelected.equals("Sango")){
                    lnInputCode="sg";
                }
                if (lanSelected.equals("Sanskrit")){
                    lnInputCode="sa";
                }
                if (lanSelected.equals("Serbian")){
                    lnInputCode="sr";
                }
                if (lanSelected.equals("Serbo-Croatian")){
                    lnInputCode="sh";
                }
                if (lanSelected.equals("Sesotho")){
                    lnInputCode="st";
                }
                if (lanSelected.equals("Setswana")){
                    lnInputCode="tn";
                }
                if (lanSelected.equals("Shona")){
                    lnInputCode="sn";
                }
                if (lanSelected.equals("Sichuan Yi")){
                    lnInputCode="ii";
                }
                if (lanSelected.equals("Sindhi")){
                    lnInputCode="sd";
                }
                if (lanSelected.equals("Sinhalese")){
                    lnInputCode="si";
                }
                if (lanSelected.equals("Siswati")){
                    lnInputCode="ss";
                }
                if (lanSelected.equals("Slovak")){
                    lnInputCode="sk";
                }
                if (lanSelected.equals("Slovenian")){
                    lnInputCode="sl";
                }
                if (lanSelected.equals("Somali")){
                    lnInputCode="so";
                }
                if (lanSelected.equals("Southern Ndebele")){
                    lnInputCode="nr";
                }
                if (lanSelected.equals("Spanish")){
                    lnInputCode="es";
                }
                if (lanSelected.equals("Sundanese")){
                    lnInputCode="su";
                }
                if (lanSelected.equals("Swahili (Kiswahili)")){
                    lnInputCode="sw";
                }
                if (lanSelected.equals("Swati")){
                    lnInputCode="ss";
                }
                if (lanSelected.equals("Swedish")){
                    lnInputCode="sv";
                }
                if (lanSelected.equals("Tagalog")){
                    lnInputCode="tl";
                }
                if (lanSelected.equals("Tahitian")){
                    lnInputCode="ty";
                }
                if (lanSelected.equals("Tajik")){
                    lnInputCode="tg";
                }
                if (lanSelected.equals("Tamil")){
                    lnInputCode="ta";
                }
                if (lanSelected.equals("Tatar")){
                    lnInputCode="tt";
                }
                if (lanSelected.equals("Telugu")){
                    lnInputCode="te";
                }
                if (lanSelected.equals("Thai")){
                    lnInputCode="th";
                }
                if (lanSelected.equals("Tibetan")){
                    lnInputCode="bo";
                }
                if (lanSelected.equals("Tigrinya")){
                    lnInputCode="ti";
                }
                if (lanSelected.equals("Tonga")){
                    lnInputCode="to";
                }

                if (lanSelected.equals("Tsonga")){
                    lnInputCode="ts";
                }

                if (lanSelected.equals("Turkish")){
                    lnInputCode="tr";
                }

                if (lanSelected.equals("Turkmen")){
                    lnInputCode="tk";
                }

                if (lanSelected.equals("Twi")){
                    lnInputCode="tw";
                }

                if (lanSelected.equals("Uyghur")){
                    lnInputCode="ug";
                }

                if (lanSelected.equals("Ukrainian")){
                    lnInputCode="uk";
                }

                if (lanSelected.equals("Urdu")){
                    lnInputCode="ur";
                }

                if (lanSelected.equals("Uzbek")){
                    lnInputCode="uz";
                }

                if (lanSelected.equals("Venda")){
                    lnInputCode="ve";
                }

                if (lanSelected.equals("Vietnamese")){
                    lnInputCode="vi";
                }

                if (lanSelected.equals("Volapük")){
                    lnInputCode="vo";
                }

                if (lanSelected.equals("Wallon")){
                    lnInputCode="wa";
                }

                if (lanSelected.equals("Welsh")){
                    lnInputCode="cy";
                }

                if (lanSelected.equals("Wolof")){
                    lnInputCode="wo";
                }

                if (lanSelected.equals("Western Frisian")){
                    lnInputCode="fy";
                }

                if (lanSelected.equals("Xhosa")){
                    lnInputCode="xh";
                }

                if (lanSelected.equals("Yiddish")){
                    lnInputCode="yi";
                }

                if (lanSelected.equals("Yoruba")){
                    lnInputCode="yo";
                }

                if (lanSelected.equals("Zhuang, Chuang")){
                    lnInputCode="za";
                }

                if (lanSelected.equals("Zulu")){
                    lnInputCode="zu";
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,SL);
        spinner2.setAdapter(arrayAdapter1);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    //Display Toast
//
////                    Toast.makeText(MainActivity.this, "Please Select your Language", Toast.LENGTH_SHORT).show();
//                }

                String lanSelected = parent.getItemAtPosition(position).toString();
//                int lanId = (int) parent.getItemAtPosition(position);



                if (lanSelected.equals("Abkhazian")){
                    lnOutputCode="ab";
                }
                if (lanSelected.equals("Afar")){
                    lnOutputCode="aa";
                }
                if (lanSelected.equals("Afrikaans")){
                    lnOutputCode="af";
                }
                if (lanSelected.equals("Akan")){
                    lnOutputCode="ak";
                }
                if (lanSelected.equals("Albanian")){
                    lnOutputCode="sq";
                }
                if (lanSelected.equals("Amharic")){
                    lnOutputCode="am";
                }
                if (lanSelected.equals("Arabic")){
                    lnOutputCode="ar";
                }
                if (lanSelected.equals("Aragonese")){
                    lnOutputCode="an";
                }
                if (lanSelected.equals("Armenian")){
                    lnOutputCode="hy";
                }
                if (lanSelected.equals("Assamese")){
                    lnOutputCode="as";
                }
                if (lanSelected.equals("Avaric")){
                    lnOutputCode="av";
                }
                if (lanSelected.equals("Avestan")){
                    lnOutputCode="ae";
                }
                if (lanSelected.equals("Aymara")){
                    lnOutputCode="ay";
                }
                if (lanSelected.equals("Bambara")){
                    lnOutputCode="bm";
                }
                if (lanSelected.equals("Bambara")){
                    lnOutputCode="ba";
                }
                if (lanSelected.equals("Basque")){
                    lnOutputCode="eu";
                }
                if (lanSelected.equals("Belarusian")){
                    lnOutputCode="be";
                }
                if (lanSelected.equals("Bengali")){
                    lnOutputCode="bn";
                }
                if (lanSelected.equals("Bihari")){
                    lnOutputCode="bh";
                }
                if (lanSelected.equals("Bislama")){
                    lnOutputCode="bi";
                }
                if (lanSelected.equals("Bosnian")){
                    lnOutputCode="bs";
                }
                if (lanSelected.equals("Breton")){
                    lnOutputCode="br";
                }
                if (lanSelected.equals("Bulgarian")){
                    lnOutputCode="bg";
                }
                if (lanSelected.equals("Burmese")){
                    lnOutputCode="my";
                }
                if (lanSelected.equals("Catalan")){
                    lnOutputCode="ca";
                }
                if (lanSelected.equals("Chamorro")){
                    lnOutputCode="ch";
                }
                if (lanSelected.equals("Chechen")){
                    lnOutputCode="ce";
                }
                if (lanSelected.equals("Chichewa, Chewa, Nyanja")){
                    lnOutputCode="ny";
                }
                if (lanSelected.equals("Chinese")){
                    lnOutputCode="zh";
                }
                if (lanSelected.equals("Chinese (Simplified)")){
                    lnOutputCode="zh-Hans";
                }
                if (lanSelected.equals("Chinese (Traditional)")){
                    lnOutputCode="zh-Hant";
                }
                if (lanSelected.equals("Chuvash")){
                    lnOutputCode="cv";
                }
                if (lanSelected.equals("Cornish")){
                    lnOutputCode="kw";
                }
                if (lanSelected.equals("Corsican")){
                    lnOutputCode="co";
                }
                if (lanSelected.equals("Cree")){
                    lnOutputCode="cr";
                }
                if (lanSelected.equals("Croatian")){
                    lnOutputCode="hr";
                }
                if (lanSelected.equals("Czech")){
                    lnOutputCode="cs";
                }
                if (lanSelected.equals("Danish")){
                    lnOutputCode="da";
                }
                if (lanSelected.equals("Divehi, Dhivehi, Maldivian")){
                    lnOutputCode="dv";
                }
                if (lanSelected.equals("Dutch")){
                    lnOutputCode="nl";
                }
                if (lanSelected.equals("Dzongkha")){
                    lnOutputCode="dz";
                }
                if (lanSelected.equals("English")){
                    lnOutputCode="en";
                }
                if (lanSelected.equals("Esperanto")){
                    lnOutputCode="eo";
                }
                if (lanSelected.equals("Estonian")){
                    lnOutputCode="et";
                }
                if (lanSelected.equals("Ewe")){
                    lnOutputCode="ee";
                }
                if (lanSelected.equals("Faroese")){
                    lnOutputCode="fo";
                }
                if (lanSelected.equals("Fijian")){
                    lnOutputCode="fj";
                }
                if (lanSelected.equals("Finnish")){
                    lnOutputCode="fi";
                }
                if (lanSelected.equals("French")){
                    lnOutputCode="fr";
                }
                if (lanSelected.equals("Fula, Fulah, Pulaar, Pular")){
                    lnOutputCode="ff";
                }
                if (lanSelected.equals("Galician")){
                    lnOutputCode="gl";
                }
                if (lanSelected.equals("Gaelic (Scottish)")){
                    lnOutputCode="gd";
                }
                if (lanSelected.equals("Gaelic (Manx)")){
                    lnOutputCode="gv";
                }
                if (lanSelected.equals("Georgian")){
                    lnOutputCode="ka";
                }
                if (lanSelected.equals("German")){
                    lnOutputCode="de";
                }
                if (lanSelected.equals("Greek")){
                    lnOutputCode="el";
                }
                if (lanSelected.equals("Greenlandic")){
                    lnOutputCode="kl";
                }
                if (lanSelected.equals("Guarani")){
                    lnOutputCode="gn";
                }
                if (lanSelected.equals("Gujarati")){
                    lnOutputCode="gu";
                }
                if (lanSelected.equals("Haitian Creole")){
                    lnOutputCode="ht";
                }
                if (lanSelected.equals("Hausa")){
                    lnOutputCode="ha";
                }
                if (lanSelected.equals("Hebrew")){
                    lnOutputCode="he";
                }
                if (lanSelected.equals("Herero")){
                    lnOutputCode="hz";
                }
                if (lanSelected.equals("Hindi")){
                    lnOutputCode="hi";
                }
                if (lanSelected.equals("Hiri Motu")){
                    lnOutputCode="ho";
                }
                if (lanSelected.equals("Hungarian")){
                    lnOutputCode="hu";
                }
                if (lanSelected.equals("Icelandic")){
                    lnOutputCode="is";
                }
                if (lanSelected.equals("Ido")){
                    lnOutputCode="io";
                }
                if (lanSelected.equals("Igbo")){
                    lnOutputCode="ig";
                }
                if (lanSelected.equals("Indonesian")){
                    lnOutputCode="id";
                }
                if (lanSelected.equals("Interlingua")){
                    lnOutputCode="ia";
                }
                if (lanSelected.equals("Interlingue")){
                    lnOutputCode="ie";
                }
                if (lanSelected.equals("Inuktitut")){
                    lnOutputCode="iu";
                }

                if (lanSelected.equals("Inupiak")){
                    lnOutputCode="ik";
                }

                if (lanSelected.equals("Irish")){
                    lnOutputCode="ga";
                }

                if (lanSelected.equals("Italian")){
                    lnOutputCode="it";
                }

                if (lanSelected.equals("Japanese")){
                    lnOutputCode="ja";
                }

                if (lanSelected.equals("Javanese")){
                    lnOutputCode="jv";
                }

                if (lanSelected.equals("Kalaallisut, Greenlandic")){
                    lnOutputCode="kl";
                }

                if (lanSelected.equals("Kannada")){
                    lnOutputCode="kn";
                }

                if (lanSelected.equals("Kanuri")){
                    lnOutputCode="kr";
                }

                if (lanSelected.equals("Kashmiri")){
                    lnOutputCode="ks";
                }

                if (lanSelected.equals("Kazakh")){
                    lnOutputCode="kk";
                }

                if (lanSelected.equals("Khmer")){
                    lnOutputCode="km";
                }

                if (lanSelected.equals("Kikuyu")){
                    lnOutputCode="ki";
                }

                if (lanSelected.equals("Kinyarwanda (Rwanda)")){
                    lnOutputCode="rw";
                }

                if (lanSelected.equals("Kirundi")){
                    lnOutputCode="rn";
                }

                if (lanSelected.equals("Kyrgyz")){
                    lnOutputCode="ky";
                }

                if (lanSelected.equals("Komi")){
                    lnOutputCode="kv";
                }

                if (lanSelected.equals("Kongo")){
                    lnOutputCode="kg";
                }

                if (lanSelected.equals("Korean")){
                    lnOutputCode="ko";
                }

                if (lanSelected.equals("Kurdish")){
                    lnOutputCode="ku";
                }

                if (lanSelected.equals("Kwanyama")){
                    lnOutputCode="kj";
                }

                if (lanSelected.equals("Lao")){
                    lnOutputCode="lo";
                }

                if (lanSelected.equals("Latin")){
                    lnOutputCode="la";
                }

                if (lanSelected.equals("Latvian (Lettish)")){
                    lnOutputCode="lv";
                }

                if (lanSelected.equals("Limburgish ( Limburger)")){
                    lnOutputCode="li";
                }

                if (lanSelected.equals("Lingala")){
                    lnOutputCode="ln";
                }

                if (lanSelected.equals("Lithuanian")){
                    lnOutputCode="lt";
                }

                if (lanSelected.equals("Luga-Katanga")){
                    lnOutputCode="lu";
                }

                if (lanSelected.equals("Luganda, Ganda")){
                    lnOutputCode="lg";
                }

                if (lanSelected.equals("Luxembourgish")){
                    lnOutputCode="lb";
                }

                if (lanSelected.equals("Manx")){
                    lnOutputCode="gv";
                }

                if (lanSelected.equals("Macedonian")){
                    lnOutputCode="mk";
                }

                if (lanSelected.equals("Malagasy")){
                    lnOutputCode="mg";
                }

                if (lanSelected.equals("Malay")){
                    lnOutputCode="ms";
                }

                if (lanSelected.equals("Malayalam")){
                    lnOutputCode="ml";
                }

                if (lanSelected.equals("Maltese")){
                    lnOutputCode="mt";
                }

                if (lanSelected.equals("Maori")){
                    lnOutputCode="mi";
                }

                if (lanSelected.equals("Marathi")){
                    lnOutputCode="mr";
                }

                if (lanSelected.equals("Marshallese")){
                    lnOutputCode="mh";
                }

                if (lanSelected.equals("Moldavian")){
                    lnOutputCode="mo";
                }

                if (lanSelected.equals("Mongolian")){
                    lnOutputCode="mn";
                }

                if (lanSelected.equals("Nauru")){
                    lnOutputCode="na";
                }

                if (lanSelected.equals("Navajo")){
                    lnOutputCode="nv";
                }

                if (lanSelected.equals("Ndonga")){
                    lnOutputCode="ng";
                }

                if (lanSelected.equals("Northern Ndebele")){
                    lnOutputCode="nd";
                }

                if (lanSelected.equals("Nepali")){
                    lnOutputCode="ne";
                }

                if (lanSelected.equals("Norwegian")){
                    lnOutputCode="no";
                }

                if (lanSelected.equals("Norwegian bokmål")){
                    lnOutputCode="nb";
                }

                if (lanSelected.equals("Norwegian nynorsk")){
                    lnOutputCode="nn";
                }
                if (lanSelected.equals("Nuosu")){
                    lnOutputCode="ii";
                }
                if (lanSelected.equals("Occitan")){
                    lnOutputCode="oc";
                }
                if (lanSelected.equals("Ojibwe")){
                    lnOutputCode="oj";
                }
                if (lanSelected.equals("Old Church Slavonic, Old Bulgarian")){
                    lnOutputCode="cu";
                }
                if (lanSelected.equals("Oriya")){
                    lnOutputCode="or";
                }
                if (lanSelected.equals("Oromo (Afaan Oromo)")){
                    lnOutputCode="om";
                }
                if (lanSelected.equals("Ossetian")){
                    lnOutputCode="os";
                }
                if (lanSelected.equals("Pāli")){
                    lnOutputCode="pi";
                }
                if (lanSelected.equals("Pashto, Pushto")){
                    lnOutputCode="ps";
                }
                if (lanSelected.equals("Persian (Farsi)")){
                    lnOutputCode="fa";
                }
                if (lanSelected.equals("Polish")){
                    lnOutputCode="pl";
                }
                if (lanSelected.equals("Portuguese")){
                    lnOutputCode="pt";
                }
                if (lanSelected.equals("Punjabi (Eastern)")){
                    lnOutputCode="pa";
                }
                if (lanSelected.equals("Quechua")){
                    lnOutputCode="qu";
                }
                if (lanSelected.equals("Romansh")){
                    lnOutputCode="rm";
                }
                if (lanSelected.equals("Romanian")){
                    lnOutputCode="ro";
                }
                if (lanSelected.equals("Russian")){
                    lnOutputCode="ru";
                }
                if (lanSelected.equals("Sami")){
                    lnOutputCode="se";
                }
                if (lanSelected.equals("Samoan")){
                    lnOutputCode="sm";
                }
                if (lanSelected.equals("Sango")){
                    lnOutputCode="sg";
                }
                if (lanSelected.equals("Sanskrit")){
                    lnOutputCode="sa";
                }
                if (lanSelected.equals("Serbian")){
                    lnOutputCode="sr";
                }
                if (lanSelected.equals("Serbo-Croatian")){
                    lnOutputCode="sh";
                }
                if (lanSelected.equals("Sesotho")){
                    lnOutputCode="st";
                }
                if (lanSelected.equals("Setswana")){
                    lnOutputCode="tn";
                }
                if (lanSelected.equals("Shona")){
                    lnOutputCode="sn";
                }
                if (lanSelected.equals("Sichuan Yi")){
                    lnOutputCode="ii";
                }
                if (lanSelected.equals("Sindhi")){
                    lnOutputCode="sd";
                }
                if (lanSelected.equals("Sinhalese")){
                    lnOutputCode="si";
                }
                if (lanSelected.equals("Siswati")){
                    lnOutputCode="ss";
                }
                if (lanSelected.equals("Slovak")){
                    lnOutputCode="sk";
                }
                if (lanSelected.equals("Slovenian")){
                    lnOutputCode="sl";
                }
                if (lanSelected.equals("Somali")){
                    lnOutputCode="so";
                }
                if (lanSelected.equals("Southern Ndebele")){
                    lnOutputCode="nr";
                }
                if (lanSelected.equals("Spanish")){
                    lnOutputCode="es";
                }
                if (lanSelected.equals("Sundanese")){
                    lnOutputCode="su";
                }
                if (lanSelected.equals("Swahili (Kiswahili)")){
                    lnOutputCode="sw";
                }
                if (lanSelected.equals("Swati")){
                    lnOutputCode="ss";
                }
                if (lanSelected.equals("Swedish")){
                    lnOutputCode="sv";
                }
                if (lanSelected.equals("Tagalog")){
                    lnOutputCode="tl";
                }
                if (lanSelected.equals("Tahitian")){
                    lnOutputCode="ty";
                }
                if (lanSelected.equals("Tajik")){
                    lnOutputCode="tg";
                }
                if (lanSelected.equals("Tamil")){
                    lnOutputCode="ta";
                }
                if (lanSelected.equals("Tatar")){
                    lnOutputCode="tt";
                }
                if (lanSelected.equals("Telugu")){
                    lnOutputCode="te";
                }
                if (lanSelected.equals("Thai")){
                    lnOutputCode="th";
                }
                if (lanSelected.equals("Tibetan")){
                    lnOutputCode="bo";
                }
                if (lanSelected.equals("Tigrinya")){
                    lnOutputCode="ti";
                }
                if (lanSelected.equals("Tonga")){
                    lnOutputCode="to";
                }

                if (lanSelected.equals("Tsonga")){
                    lnOutputCode="ts";
                }

                if (lanSelected.equals("Turkish")){
                    lnOutputCode="tr";
                }

                if (lanSelected.equals("Turkmen")){
                    lnOutputCode="tk";
                }

                if (lanSelected.equals("Twi")){
                    lnOutputCode="tw";
                }

                if (lanSelected.equals("Uyghur")){
                    lnOutputCode="ug";
                }

                if (lanSelected.equals("Ukrainian")){
                    lnOutputCode="uk";
                }

                if (lanSelected.equals("Urdu")){
                    lnOutputCode="ur";
                }

                if (lanSelected.equals("Uzbek")){
                    lnOutputCode="uz";
                }

                if (lanSelected.equals("Venda")){
                    lnOutputCode="ve";
                }

                if (lanSelected.equals("Vietnamese")){
                    lnOutputCode="vi";
                }

                if (lanSelected.equals("Volapük")){
                    lnOutputCode="vo";
                }

                if (lanSelected.equals("Wallon")){
                    lnOutputCode="wa";
                }

                if (lanSelected.equals("Welsh")){
                    lnOutputCode="cy";
                }

                if (lanSelected.equals("Wolof")){
                    lnOutputCode="wo";
                }

                if (lanSelected.equals("Western Frisian")){
                    lnOutputCode="fy";
                }

                if (lanSelected.equals("Xhosa")){
                    lnOutputCode="xh";
                }

                if (lanSelected.equals("Yiddish")){
                    lnOutputCode="yi";
                }

                if (lanSelected.equals("Yoruba")){
                    lnOutputCode="yo";
                }

                if (lanSelected.equals("Zhuang, Chuang")){
                    lnOutputCode="za";
                }

                if (lanSelected.equals("Zulu")){
                    lnOutputCode="zu";
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                translate_api translate=new translate_api();
                translate.setOnTranslationCompleteListener(new translate_api.OnTranslationCompleteListener() {
                    @Override
                    public void onStartTranslation() {
                        // here you can perform initial work before translated the text like displaying progress bar
                    }

                    @Override
                    public void onCompleted(String text) {
                        // "text" variable will give you the translated text
                        translatedText.setText(text);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
                translate.execute(Objects.requireNonNull(text.getText()).toString(),lnInputCode,lnOutputCode);
            }
        });
    }

    }
