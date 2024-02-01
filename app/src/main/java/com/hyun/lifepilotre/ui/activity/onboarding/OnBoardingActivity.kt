package com.hyun.lifepilotre.ui.activity.onboarding

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.hyun.lifepilotre.R
import com.hyun.lifepilotre.ui.register.RegisterInsertEmailActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        //1. 슬라이드용 화면 준비
        val onBoardingFirstScreen = PaperOnboardingPage (
            "환영합니다!! \n라이프 파일럿입니다.",
            "건강한 삶은 더 나은 삶이 될 수 있습니다.",
            Color.parseColor("#99CCFF"),
            R.drawable.onboarding_first_screen,
            R.drawable.onboarding_status_screen,
        )

        val onBoardingSecondScreen = PaperOnboardingPage(
            "건강한 삶을 위한 파트너",
            "라이프 파일럿은 건강한 식단 계획, 운동의 방향성, 맞춤형 건강 조언을 해드립니다!",
            Color.parseColor("#CCE5FF"), R.drawable.onboarding_second_screen, R.drawable.onboarding_status_screen
        )
        val onBoardingThirdScreen = PaperOnboardingPage(
            "건강 관리는 필수!",
            "함께 건강한 라이프스타일을 즐겨봐요!",
            Color.parseColor("#CCCCFF"), R.drawable.onboarding_third_screen, R.drawable.onboarding_status_screen
        )

        val onBoardingElements = ArrayList<PaperOnboardingPage>()
        onBoardingElements.add(onBoardingFirstScreen)
        onBoardingElements.add(onBoardingSecondScreen)
        onBoardingElements.add(onBoardingThirdScreen)


        //2. 화면을 온보드 프래그먼트에 넣는다.
        val onBoardingFragment = PaperOnboardingFragment.newInstance(onBoardingElements)


        //3. 프래그먼트 화면설정 완료
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.containers, onBoardingFragment)
        fragmentTransaction.commit()


        //4. 온보드 완료시에 보여줄 프래그먼트 설정
        onBoardingFragment.setOnRightOutListener {
            val intent = Intent(this, RegisterInsertEmailActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.hold)
        }
    }
}