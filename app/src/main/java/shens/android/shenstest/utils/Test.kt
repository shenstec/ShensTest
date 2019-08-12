package shens.android.shenstest.utils

import android.util.Log

/**
 *
 * @ProjectName:    ShensTest
 * @Package:        shens.android.shenstest.utils
 * @ClassName:      Test
 * @Description:     java类作用描述
 * @Author:         作者名
 * @CreateDate:     2019/7/19 2:19 PM
 * @UpdateUser:     更新者：
 * @UpdateDate:     2019/7/19 2:19 PM
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @website:       http://www.hitucao.com
 */

class Test {
    fun say(){
        Log.e("Kotlin","无参数")
    }

    fun people(hello:()->Unit){
        hello()
    }

    fun mainTest(){
        people({
            say()
        })
        people { say() }
    }
}