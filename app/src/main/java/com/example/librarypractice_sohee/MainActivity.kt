package com.example.librarypractice_sohee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileImg.setOnClickListener{

//            프로필 크게 보는 액티비티로 이동

            val myIntent = Intent(this, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

//        인터넷에 있는 이미지 (https://~)를 이미지뷰에 바로 대입

        Glide.with(this).load("http://www.nepp.kr/_nuxt/img/a2e717a.png").into(lectureImg1)

//        전화걸기 버튼 누르기 -> 권한 확인 / 전화 연결

        callBtn.setOnClickListener {

//            라이브러리 활용 -> 전화 권한 확인 -> 실제 전화 연결
        }

    }
}