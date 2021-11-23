<template>
  <div class="pt-5 pb-1 border-b mb-2 ">
      <i class='bx bxs-user text-gray-500 text-sm pr-2'></i>
      <input type="text" class="outline-none" placeholder="Họ tên" v-model="user.fullName">
  </div>
  <div class="pb-1 text-red-500 text-sm">
    {{ userError.fullName }}
  </div>
  <div class="pt-5 pb-1 border-b mb-2 relative">
      <i class='bx bx-mobile-alt text-gray-500 text-sm pr-2'></i>
      <input type="text" class="outline-none" placeholder="Email hoặc số điện thoại" 
        v-model="user.email"
        @input="checkEmail">
      <!-- loading -->
      <i class="text-red-500 cursor-pointer select-none text-sm absolute right-0 bottom-2 animate-spin bx bx-loader-circle" :class="{'hidden': !loadingSendVerify}"></i>
      <span class="text-red-500 cursor-pointer select-none text-xs absolute right-0 bottom-2" 
        :class="[user.email.length > 0 ? '' : 'hidden']" @click="requestVerifyMail">{{ textRequestMail }}</span>
  </div>
  <!-- form nhap ma -->
  <div class="pt-5 pb-1" :class="[verifying ? '' : 'hidden']"> 
    <span class='text-blue-400 text-sm pr-2'>Nhập mã:</span>
    <input type="text" class="outline-none w-36 pl-2 border-b mb-2" style="letter-spacing: 0.8rem; width: 9rem;" placeholder="xxxxxx" maxlength="6"
      v-model="code" @input="verifyMail">
    <img src="../assets/images/loading-buffering.gif" :class="[code.length == 6 ? 'inline' : 'hidden']" style="width: 21px; margin-left: 12px;" alt="Loading">
    <i class='bx bxs-error-circle text-xl leading-5 text-red-500 align-middle ml-3' :class="{'hidden': !verifyEror}"></i>
  </div>

  <div class="pb-1 text-red-500 text-sm">
    {{ userError.email }}
  </div>

  <div class="pt-4 pb-1 border-b mb-2">
      <i class='bx bxs-lock text-gray-500 text-sm pr-2' ></i>
      <input type="password" class="outline-none" placeholder="Mật khẩu" v-model="user.password">
  </div>
  <div class="pb-1 text-red-500 text-sm">
    {{ userError.password }}
  </div>
  <div class="pt-4 pb-1 border-b mb-2">
      <i class='bx bxs-lock text-gray-500 text-sm pr-2' ></i>
      <input type="password" class="outline-none" placeholder="Nhập lại mật khẩu" v-model="user.repassword">
  </div>
  <div class="pb-1 text-red-500 text-sm">
    {{ userError.repassword }}
  </div>
  <div>
      <button class="bg-[#0190f3] w-full mt-4 h-11 text-white rounded mb-2 font-bold" @click="register">
        <!-- loading -->
        <i class="text-white select-none text-lg animate-spin bx bx-loader-circle" :class="{'hidden': !loadingRegister}"></i>
        Đăng ký
      </button>
  </div>
  <p class="text-center m-4">
      <a href="#">Quên mật khẩu?</a>
  </p>
</template>

<script>
export default {
  name: 'Register',
  mounted() {
    document.title = this.$route.meta.title
  },
  emits: ['registered'],
  data() {
    return {
      user: {
        fullName: '',
        email: '',
        password: '',
        repassword: ''
      },
      userError: {
        fullName: '',
        email: '',
        password: '',
        repassword: ''
      },
      verifying: false,
      code: '',
      verifyEror: false,
      textRequestMail: 'Lấy mã',
      loadingSendVerify: false,
      loadingRegister: false
    }
  },
  methods: {
    checkEmail() {
      if (this.user.email.length == 0 || this.user.email == localStorage.getItem('mail'))
        this.verifying = false
    },
    async requestVerifyMail() {
      if (this.textRequestMail != 'Lấy mã') {
        if (localStorage.getItem('mail') != this.user.email) {
          let check = confirm("Email này đã được xác minh, bạn muốn xóa nó không?")
          if (check) 
            this.textRequestMail = 'Lấy mã'
        }
        return
      }
      if (localStorage.getItem('mail') == this.user.email) {
        this.textRequestMail = '✔'
        this.verifying = false
        return
      }

      // block spam
      this.textRequestMail = ''
      this.loadingSendVerify = true
      setTimeout(() => {
        this.textRequestMail = 'Lấy mã'
        this.loadingSendVerify = false
      }, 15000)

      this.verifying = true
      const response = await fetch('http://localhost:8080/api/v1/users/verification', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({email: this.user.email})
      });
      const data = await response.json()
      console.log(data)
    },
    async verifyMail() {
      if (this.code.length == 6) {
        this.verifyEror = false
        const response = await fetch('http://localhost:8080/api/v1/users/verification/code', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({email: this.user.email, code: this.code})
        });
        const data = await response.json();
        console.log(data)
        this.code = ''
        if (data.status != 200) {
          this.verifyEror = true
          this.userError.email = data.message
        } 
        else {
          this.verifying = false
          this.textRequestMail = '✔'
          this.userError.email = ''
          localStorage.setItem('mail', this.user.email)
        }
      }
    },
    async register() {
      if (this.user.password != this.user.repassword) {
        this.userError.repassword = 'Mật khẩu không khớp với ô trên!'
        return
      }
      this.loadingRegister = true
      try {
        const response = await fetch('http://localhost:8080/api/v1/users', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.user)
        }) 
        const data = await response.json()
        if (data.status != 200) {
          this.userError = data.data
        } else {
          this.$emit('registered')
        }
      } catch(e) {
        console.log(e)
      }
      this.loadingRegister = false 
    }
  }
}
</script>

<style scoped>
input {
  width: 90%;
}
</style>