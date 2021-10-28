<template>
  <!-- left container -->
    <div class="bg-blue-500 flex flex-col w-16 items-center h-screen py-4 hidden md:block">
        <!-- avatar -->
        <div class="rounded-full w-11 h-11 mb-10 border border-white cursor-pointer mx-auto">
            <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full">
        </div>
        <!-- menu -->
        <div class="flex flex-col w-full items-center cursor-pointer  ">
            <!-- message -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400 bg-blue-600">
                <i class='bx bxs-message-rounded-detail text-3xl text-white'></i>
            </div>

            <!-- danh ba -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                <i class='bx bxs-contact text-3xl text-white'></i>
            </div>

            <!-- chuong -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                <i class='bx bx-bell text-3xl text-white'></i>
            </div>

            <!-- note -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400">
                <i class='bx bx-notepad text-3xl text-white'></i>
            </div>
        </div>

    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>