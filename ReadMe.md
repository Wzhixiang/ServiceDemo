### 关于启动Service方式生命周期变化
        
         * 从startService到stopService: onCreate->onStartCommand->onDestroy
         * 从bindSergvice到unbindService: onCreate->onBind->onDestroy
         * 先startService，然后bindSergvice，销毁Service只是使用unbindService: onCreate->onStartCommand->onBind
         * 先bindSergvice，然后startService，销毁Service只是使用stopService: onCreate->onBind->onStartCommand