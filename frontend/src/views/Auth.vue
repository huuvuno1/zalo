<template>
  <div class="wrap_auth pt-7 h-screen md:pt-16">
    <!-- logo &  -->
    <div class="">
        <div>
            <img src="../assets/images/zlogo.png" alt="" class="h-9 mx-auto select-none">
        </div>
        <h2 class="text-center text-lg mt-3 leading-6 mb-4 text-gray-700">
            {{ getTitle }} tài khoản Zalo <br> để kết nối với ứng dụng Zalo Chat
        </h2>
    </div>
    <div class="bg-white mx-auto max-w-sm shadow-md rounded-sm md:box-content md:px-4 my_90">
        <!-- type -->
        <div class="flex h-12 cursor-pointer" id="type">
            <h3 class="flex-1 text-center uppercase text-xs relative select-none" 
                :class="isLogin ? ['font-bold', 'text-black'] : 'text-blue-600'"
                @click="togglePage">
                Đăng nhập
                <div class="my_seperate"></div>

                <!-- show if div is selected -->
                <div class="my__select" v-if="isLogin"></div>
            </h3>
            <h3 class="select-none flex-1 text-center uppercase text-xs relative " 
                :class="!isLogin ? ['font-bold', 'text-black'] : 'text-blue-600'"
                @click="togglePage">
                Đăng ký
                <div class="my__select" v-if="!isLogin"></div>
            </h3>
        </div>

        <!-- form type -->
        <div class="px-4 pb-1">
            <login v-if="isLogin" />
            <register v-else />
        </div>
    </div>
</div>
</template>

<script>
import Login from '@/components/Login.vue'
import Register from '@/components/Register.vue'


export default {
    data() {
        return {
            isLogin: false
        }
    },
    computed: {
        getTitle() {
            return this.isLogin ? 'Đăng nhập' : 'Đăng ký'
        }
    },
    mounted() {
        this.isLogin = this.$route.name === "Login"
    },
    components: {
        Login,
        Register
    },
    methods: {
        togglePage() {
            if (this.isLogin) {
                this.$router.push({name: 'Register'})
            }
            else {
                this.$router.push({name: 'Login'})
            }
            this.isLogin = !this.isLogin
        }
    }
}
</script>

<style lang="scss" scoped>
.wrap_auth {
    background-image: url('../assets/images/background.png');
}
#type h3 {
    line-height: 48px;
}

.my__select {
    position: absolute;
    width: 70%;
    border-top: 1px solid black;
    bottom: 0;
    margin-left: auto;
    margin-right: auto;
    left: 0;
    right: 0;
}

.my_seperate {
    position: absolute;
    height: 36%;
    border-right: 2px solid #b3acac;
    right: 0;
    margin-top: auto;
    margin-bottom: auto;
    top: 0;
    bottom: 0;
}

@media (max-width: 768px) {
    .my_90 {
        max-width: 90%;
    }
}

</style>