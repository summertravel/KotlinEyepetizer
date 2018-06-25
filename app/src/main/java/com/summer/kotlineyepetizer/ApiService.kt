package com.summer.kotlineyepetizer

import com.summer.kotlineyepetizer.bean.Bean
import io.reactivex.Flowable

/*
 *  Created on 2018/6/20.
 *  Created by open ability group.
 *  Copyright (c) open ability group All rights reserved.
 */
interface ApiService {
    fun homepage(): Flowable<Bean>

}