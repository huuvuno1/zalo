<template>
  <!-- search -->
    <div class="flex-1 border-b border-gray-300 flex items-center relative">
        <i class='bx bx-search mr-2 cursor-pointer'></i>
        <input type="text" placeholder="Tìm kiếm" id="txtSearch" class="outline-none flex-1" v-model="txtSearch">
        <span class="my__close" :class="[txtSearch === '' ? 'hidden' : 'block']" @click="txtSearch = ''">x</span>
        <div class="absolute top-7 left-0 right-0 bg-gray-100" :class="[txtSearch === '' ? 'hidden' : '']"> 
            {{txtSearch}}
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
    }
}
</script>

<style>

</style>