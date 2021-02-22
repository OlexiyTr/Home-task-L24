package com.example.home_task_mvvm_livedata.domain

class UserStateConditions {
    companion object {
        private const val WARNINGS_USER = 3
        private const val WARNINGS_USER_NEXT = 4
        private const val BANNED_USER = 7
    }


    fun getBlackList(): MutableList<BadUserModel> {
        val blackList = mutableListOf<BadUserModel>()

        blackList.add(BadUserModel(WARNINGS_USER, UserState.HAS_WARNING))
        blackList.add(BadUserModel(WARNINGS_USER_NEXT, UserState.HAS_WARNING))
        blackList.add(BadUserModel(BANNED_USER, UserState.BANNED))

        return blackList
    }
}