package com.hyun.lifepilotre.util

import com.ramotion.paperonboarding.PaperOnboardingPage

class PaperOnBoardingPage {
    fun loadOnBoardingPage(
        titleText: String,
        descriptionText: String,
        parseColor: Int,
        onboardingSecondScreen: Int,
        onboardingStatusScreen: Int,
    ) : PaperOnboardingPage {
        return PaperOnboardingPage (
            titleText,
            descriptionText,
            parseColor,
            onboardingSecondScreen,
            onboardingStatusScreen,
        )
    }
}