package com.example.librarypractice_sohee

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {

//                    권한이 승인된 경우 - 실제로 전화 연결 진행

                    val myUri = Uri.parse("tel: 010-1111-1111")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)

                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

//                    권한이 거절된 경우 - 토스트로 권한이 없어서 전화 연결 실패

                    Toast.makeText(this@MainActivity, "권한이 없어서 전화 연결에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }


            }

            TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("전화 연결 권한이 필요합니다. [설정]에서 진행해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

    }
}