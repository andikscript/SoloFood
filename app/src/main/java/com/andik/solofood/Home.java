package com.andik.solofood;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends Fragment {

    // deklarasi array yang digunakan untuk ditampilkan pada ListView di dalam fragment
    private String[] title = {"Timlo", "Nasi Liwet", "Serabi", "Selat Solo", "Sate Buntel", "Tengkleng", "Brambang Asem", "Lenjongan","Es Dawet Selasih", "Es Gempol Pleret"};
    private String[] deskripsi = {
            "Makan timlo di Solo adalah keharusan. Untuk mendapatkan yang terbaik, silakan berkunjung ke Warung Timlo Solo Sastro di wilayah Pasar Gede. Kuliner soto dengan citarasa sup ini menawarkan kesegaran dalam setiap suapan.\n" +
                    "\n" +
                    "Untuk mendapatkan kesan mendalam, materi soto di dalamnya harus kamu cicipi, seperti mie soun, suwiran ayam, potongan sosis Solo, wortel dan irisan telur masak kecap. \n" +
                    "\n"+
                    "Tambahkan irisan hati ayam dan telur dadar untuk melengkapi hidangan sebelum kemudian disiram kuah kaldu panas yang menyegarkan. Dengan ditambah bawang goreng sebagai penambah rasa, timlo Solo bakal memuaskan nafsu makan kamu.",
            "Makanan khas Solo yang satu ini memiliki reputasinya tersendiri. Nasi putih yang disajikan dalam pincuk daun pisang bersama dengan sayur labu siam, suwiran ayam dan telur rebus ditambah sedikit santan kental gurih  yang disebut areh ini akan membawa kamu ke dunia yang berbeda.\n" +
                    "\n" +
                    "Salah satu penyaji nasi liwet yang ikonik di Kota Solo adalah Nasi Liwet Wongso Lemu. Harganya memang sedikit lebih mahal dibandingkan penjual nasi liwet Solo lainnya, namun rasanya memang memiliki ciri khas tersendiri.",
            "Serabi memang sudah membuka cabang di seluruh Indonesia, tapi jika kamu ingin mencoba yang asli, silakan langsung mampir ke Solo.\n" +
                    "\n" +
                    "Serabi Notosuman sudah melayani pelanggannya sejak 1920-an, dan mereka sukses bertahan karena mempertahankan cita rasanya yang manis, lembut dengan santan yang terasa kuat di mulut. Jika membelinya langsung di Notosuman, kamu juga bisa mendapat bonus melihat langsung pembuatan serabi dengan teknik yang menjaga kearifan lokal. Oh iya, untuk mendapatkannya, kamu harus mengantri karena peminatnya sangat banyak. ",
            "Selat solo adalah hidangan khas Jawa dengan pengaruh dari Eropa dan merupakan makanan khas Solo. Untuk menikmatinya, kamu bisa menuju ke Warung Selat Mbak Lies.\n" +
                    "\n" +
                    "Lokasinya tersembunyi dan interior warungnya juga unik. Bayangkan rasa yang kamu dapat kala menikmati seporsi sup lengkap dengan wortel, tomat dan buncis, ditambah acar bawang goreng, potongan kentang goreng, irisan telur pindang dan sayur mayones, plus potongan daging bistik. Penasaran seperti apa rasanya, well, kamu harus mencobanya langsung.",
            "Konon kabarnya presiden kedua Indonesia, Soeharto, sangat menyukai hidangan ini. Bapak Joko Widodo pun juga termasuk salah satu penggemarnya. Jika dua orang paling berpengaruh di tanah air itu saja menyukainya, mengapa kamu tidak mencobanya.\n" +
                    "\n" +
                    "Sate yang terbuat dari daging kambing cacah yang kemudian dibungkus dengan lapisan lemak tipis dan kemudian dibakar, memang memberikan nuansa tersendiri bagi penikmatnya. Lemak pembungkus yang terbakar menambah aroma, yang mengundang kamu untuk segera menikmatinya. Dengan bumbu kecap, irisan bawang merah dan daun kol, serta jeruk nipis dan cabai rawit sebagai tambahan, kamu akan mengetahui alasan mengapa Soeharto dan pak Jokowi begitu menyukai Sate Buntel ini.",
            "Tengkleng memang menjadi salah satu makanan khas Solo yang harus kamu coba, dan tempat yang tepat untuk mereka yang baru pertama mencobanya adalah di Tengkleng Bu Edi. Masakan yang mirip dengan gulai tersebut memiliki kuah yang lebih cair dan berisi tulang kambing dengan sedikit daging yang melekat. Cara penyajian tengkleng di atas pincuk juga menambah kenikmatan tersendiri. Kamu bisa menyeruput kuah langsung dari pincuknya. Rasanya nikmat banget, lho!",
            "Ingin merasakan makanan khas Solo tempoe doeloe, silakan mencicipi Brambang Asem. Seperti namanya, Brambang Asem merupakan makanan yang terbuat dari daun ubi jalar yang direbus, beraroma bawang merah dengan rasa pedas, yang bisa disantap dengan tempe gembus, tempe yang terbuat dari ampas tahu. Brambang Asem bukan merupakan hidangan utama, melainkan camilan untuk menikmati hari.\n" +
                    "\n" +
                    "Tidak ada salahnya mencoba hidangan yang cukup istimewa ini dari Yu Sum (Pasar Gede) kala berkunjung ke Solo.",
            "Jajanan tradisional gabungan dari sejumlah cemilan manis khas Solo, seperti tiwul, ketan hitam, ketan putih, gethuk, sawut, cenil dan klepon. Rasanya yang manis membuat Lenjongan lebih mudah diterima oleh banyak kalangan. \n"+
                    "\n" +
                    "Lenjongan terdiri dari berbagai jenis komposisi makanan, seperti ketan ireng (ketan hitam), klepon, getuk, tiwul, ketan putih, cenil dan masih banyak lagi jajanan basah lainnya. Campuran ini yang menjadi favorit karena menyatukan berbagai  jenis rasa tradisional dalam satu wadah.  Ketan ireng dalam campuran lenjongan dibuat menjadi bubur. \n" +
                    "\n" +
                    "Biasanya berasa manis dengan tekstur lunak. Penyajian ketan hitam atau ireng dipadu dengan santan. Pada lenjongan, santan bisa diganti dengan guyuran gula merah cair. Ada juga dalam lenjongan ketan putih. Ketan putih menambah kekayaan cita rasa berbeda dalam sebuah pincuk.",
            "Ingin makanan khas Solo yang menyegarkan? Es dawet telasih dari Es Dawet Telasih Bu Dermi adalah pilihan yang pas. Kabarnya, es dawet ini juga menjadi salah satu kuliner favorit presiden Jokowi, lho!\n" +
                    "\n" +
                    "Rasanya yang manis dan segar menjadikan es dawet telasih ini menjadi incaran siapa pun yang puas berbelanja di Pasar Gede. Namun untuk bisa mendapatkan satu porsi es dawet telasih ini, kamu harus menunggu untuk waktu yang relatif tidak sebentar karena peminatnya sangat banyak.",
            "Es gempol pleret juga bisa menjadi alternatif yang pas bagi kamu pemburu makanan khas Solo yang dingin dan menyegarkan. Terbuat dari tepung beras, disajikan bersama cendol dawet, gempol pleret paling pas dinikmati dalam kondisi dingin. Rasanya yang manis, diwarnai aroma wangi daun pandan membuat sajian ini menjadi salah satu yang dicari saat udara panas dan dahaga menyerang.\n" +
                    "\n" +
                    "Sayangnya sudah tidak banyak penjual es gempol pleret di sekitaran Solo, selain Es Gempol Pleret Pak Suhar.",
    };
    // deklarasi nilai int yang menyimpan alamat dari image di dalam aplikasi ini
    private int[] image = {R.drawable.timlo,R.drawable.nasiliwet,R.drawable.serabi,R.drawable.selat,R.drawable.satebuntel,R.drawable.tengkleng,R.drawable.brambangasem,R.drawable.lenjongan,R.drawable.dawetselasih,R.drawable.gempolpleret};

    // method yang pertama kali dipanggil ketika fragment ini ditampilkan
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // deklarasi ArrayList yang digunakan untuk menyimpan nilai dari String title, deskripsi dan int image
        ArrayList<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        // deklarasi rootView yang digunakan untuk menampilkan fragment dari layout fragment_home
        View rootView = inflater.inflate(R.layout.fragment_home, null);
        // deklarasi dari ListView yang digunakan untuk menghandle dari id list di layout fragment_home
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // perulangan for yang digunakan untuk membuat list di dalam layout
        for (int i = 0; i < image.length; i++) {
            // deklarasi HashMap yang dimana HashMap adalah array khusus yang menyimpan nilai dengna model key-value
            HashMap<String, String> has = new HashMap<String, String>();
            // method .put digunakan untuk memasukkan nilai ke dalam HashMap
            has.put("image", Integer.toString(image[i]));
            has.put("title", title[i]);
            has.put("deskripsi", deskripsi[i].substring(0,55) + "..");
            // perintah dibawah ini digunakan untuk menambahkan data yang berada pada kedalam ArrayList, Karena di dalam
            // ArrayList ada HashMap
            aList.add(has);

            // deklarasi array from dan to, yang dimana from digunakan untuk menandai dari nilai dari HashMap has
            // dan to untuk merubahnya ke dalam nilai dan ditampilkan ke id pada variable to
            String[] from = {"title", "deskripsi", "image"};
            int[] to  = {R.id.list_title, R.id.list_deskripsi, R.id.list_image};

            // SimpleAdapter berfungsi untuk menyimpan model frame yang dibuat
            // dengan memberikan nilai variable aList ke layout list_home dan menampilkan hasil ke layar
            // dengan mereplace nilai aList menggunakan variable from dan menampilkan hasilnya menggunakan variable to
            SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), aList, R.layout.list_home, from, to);
            // menampilkan hasilnya yang dibuat oleh SimpleAdapter ke listView
            listView.setAdapter(simpleAdapter);
            // method dibawah ini untuk menghandle event Click pada setiap list untuk berganti ke activity Detail.class
            // dengan membawa nilai posisi dari position yang di click
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent in = new Intent(getActivity(), Detail.class)
                            .putExtra("posisi", position);
                    startActivity(in);
                }
            });
        }
        // untuk mengembalikan nilai rootView yang dimana untuk menampilkan view dari fragment ini
        return rootView;
    }
}
