<template>
  <!-- left container -->
    <div class="bg-blue-500 flex flex-col w-12 md:w-16 items-center h-screen py-4 md:block">
        <!-- avatar -->
        <div class="rounded-full w-10 h-10 md:w-11 md:h-11  mb-10 border border-white cursor-pointer mx-auto">
            <img src="../assets/images/background.png" alt="" class="w-full h-full rounded-full" style="min-height: 40px;">
        </div>
        <!-- menu -->
        <div class="flex flex-col w-full items-center cursor-pointer">
            <!-- message -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400" :class="{'bg-blue-600': item_selected == 1}">
                <i class='bx bxs-message-rounded-detail text-3xl text-white'></i>
            </div>

            <!-- danh ba -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400" :class="{'bg-blue-600': item_selected == 2}">
                <i class='bx bxs-contact text-3xl text-white'></i>
            </div>

            <!-- chuong -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400" :class="{'bg-blue-600': item_selected == 3}">
                <i class='bx bx-bell text-3xl text-white'></i>
            </div>

            <!-- note -->
            <div class="h-16 w-full text-center pt-4 hover:bg-blue-400" :class="{'bg-blue-600': item_selected == 4}">
                <i class='bx bx-notepad text-3xl text-white'></i>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    name: 'TaskBar',
    data() {
        return {
            item_selected: 1
        }
    }
}
</script>

<style>

</style>