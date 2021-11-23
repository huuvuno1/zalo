<template>
  <div class="pt-5 pb-1 mb-1 text-red-500" :class="[textLoginError == '' ? 'hidden' : '']">
      {{ textLoginError }}
  </div>
  <div class="pt-5 pb-1 border-b mb-2">
      <i class='bx bx-mobile-alt text-gray-500 text-sm pr-2'></i>
      <input type="text" class="outline-none" placeholder="Email hoặc số điện thoại" v-model="user.email">
  </div>
  <div class="pt-4 pb-1 border-b mb-2">
      <i class='bx bxs-lock text-gray-500 text-sm pr-2' ></i>
      <input type="password" class="outline-none" placeholder="Mật khẩu" v-model="user.password">
  </div>
  <div>
    
      <button class="bg-[#0190f3] w-full mt-4 h-11 text-white rounded mb-2 font-bold" @click="login">
        <i class='bx bx-loader-circle animate-spin text-base' :class="{'hidden': !buttonLoading}"></i>
        Đăng nhập
      </button>
  </div>
  <p class="text-center m-4">
      <a href="#">Quên mật khẩu?</a>
  </p>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      user: {
        email: '',
        password: ''
      },
      userError: {
        email: '',
        password: ''
      },
      buttonLoading: false,
      textLoginError: ''
    }
  },
  mounted() {
    console.log("oke")
    document.title = this.$route.meta.title
  },
  methods: {
    async login() {
      this.buttonLoading = true
      try {
      const response = await fetch('http://nguyenhuuvu.com:8080/api/v1/users/auth', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.user),
          credentials: 'include'
        });
        const data = await response.json()
        if (data.status == 200) {
          location.href = '/chat/1'
        } else {
          this.textLoginError = data.message
        }
      }
      catch(e) {
        console.log(e)
      }
      this.buttonLoading = false
      
    }
  }
}
</script>

<style scoped>
input {
  width: 90%;
}
</style>