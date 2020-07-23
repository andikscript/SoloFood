package com.andik.solofood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.andik.solofood.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

public class Detail extends AppCompatActivity {

    private String[] title = {"Timlo Solo", "Nasi Liwet Solo", "Serabi Solo", "Selat Solo", "Sate Buntel", "Tengkleng Kambing", "Brambang Asem", "Lenjongan","Es Dawet Selasih", "Es Gempol Pleret"};
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

    private int[] image = {R.drawable.timlo,R.drawable.nasiliwet,R.drawable.serabi,R.drawable.selat,R.drawable.satebuntel,R.drawable.tengkleng,R.drawable.brambangasem,R.drawable.lenjongan,R.drawable.dawetselasih,R.drawable.gempolpleret};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        // deklarasi View dengan menggunakan library (di gradle : implementation 'com.mikhaellopez:circularimageview:3.2.0')
        // untuk membuat foto menjadi lingkaran
        CircularImageView ci = (CircularImageView) findViewById(R.id.image_food);

        TextView txtTitle = (TextView) findViewById(R.id.title_food);
        //deklarasi View dengan menggunakan library (compile 'com.uncopt:android.justified:1.0') agar tampilan dari TextView
        // menjadi rata kanan kiri (justify)
        JustifiedTextView txtDeskripsi = (JustifiedTextView) findViewById(R.id.deskripsi_food);

        // menngambil nilai dari position yang dikirim dari fragment Home
        // yang fungsinya untuk menampilkan title, deskripsi, dan image sesuai posisi
        // image yang di klik
        Intent in = getIntent();
        Integer position = (Integer) in.getSerializableExtra("posisi");
        // untuk menampilkan text title berdasarkan position dari list yang diklik
        txtTitle.setText(title[position]);
        // untuk menampilkan text deskripsi berdasarkan position dari list yang diklik
        txtDeskripsi.setText(deskripsi[position]);
        // untuk menampilkan image berdasarkan position dengan menggunakan nilai int dari alamat image
        ci.setImageResource(image[position]);

    }

    // method untuk menghandle event dari backClick agar activity ini berada dibelakang
    public void backClick(View v) {
        super.onBackPressed();
    }
}
