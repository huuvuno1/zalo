<template>
  <div class="pt-5 pb-1 border-b mb-2 ">
      <i class='bx bxs-user text-gray-500 text-sm pr-2'></i>
      <input type="text" class="outline-none" placeholder="Họ tên" v-model="user.fullName">
  </div>
  <div class="pt-5 pb-1 border-b mb-2">
      <i class='bx bx-mobile-alt text-gray-500 text-sm pr-2'></i>
      <input type="text" class="outline-none" placeholder="Email hoặc số điện thoại" v-model="user.email">
  </div>
  <div class="pt-4 pb-1 border-b mb-2">
      <i class='bx bxs-lock text-gray-500 text-sm pr-2' ></i>
      <input type="password" class="outline-none" placeholder="Mật khẩu" v-model="user.password">
  </div>
  <div class="pt-4 pb-1 border-b mb-2">
      <i class='bx bxs-lock text-gray-500 text-sm pr-2' ></i>
      <input type="password" class="outline-none" placeholder="Nhập lại mật khẩu" v-model="user.repassword">
  </div>
  <div>
      <button class="bg-[#0190f3] w-full mt-4 h-11 text-white rounded mb-2 font-bold" @click="register">Đăng ký</button>
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
  data() {
    return {
      user: {
        'fullName': '',
        'email': '',
        'password': '',
        'repassword': ''
      }
    }
  },
  methods: {
    register() {
      console.log(this.user)
    }
  }
}
</script>

<style scoped>
input {
  width: 90%;
}
</style>