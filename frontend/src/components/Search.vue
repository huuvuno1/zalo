<template>
  <!-- search -->
  <div class="px-2 py-4 flex">
        
    <div class="flex-1 border-b border-gray-300 flex items-center relative" id="test__parent">
        <i class='bx bx-search mr-2 cursor-pointer'></i>
        <input autocomplete="none" type="text" placeholder="Tìm kiếm" id="txtSearch" class="outline-none flex-1" v-model="txtSearch" @input="event => txtSearch = event.target.value">
        <span class="my__close" :class="[txtSearch === '' ? 'hidden' : 'block']" @click="txtSearch = ''">x</span>
        <div class="absolute top-7 left-0 right-0 bg-white shadow-2xl w-full p-1 z-50 border rounded-md" :class="[txtSearch === '' ? 'hidden' : '']"> 
            <h1 class="font-bold border-gray-200 border-b my-2 ml-1">Kết quả tìm kiếm</h1>
            <!-- result search -->
            <div class="overflow-x-hidden overflow-y-scroll h-72">
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>
                <div class="flex items-center bg-white rounded my-1 p-1 cursor-pointer hover:bg-gray-100">
                    <div class="w-8 h-8 rounded-full">
                        <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
                    </div>
                    <h1 class="flex-grow ml-2">Nguyen Van C</h1>
                    <i class='bx bx-user-plus mr-2 text-xl text-blue-500'></i>
                </div>

            </div>
            
            
        </div>
    </div>
    </div>
</template>

<script>
export default {
    name: 'Search',
    data() {
        return {
            txtSearch: ''
        }
    },
    methods: {
    }
}
</script>

<style>

</style>