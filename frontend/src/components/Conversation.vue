<template>
  <!-- frame mess -->
  <!-- set bg if trung id:  bg-blue-100 -->
  <div class="h-16 flex items-center hover:bg-gray-100 cursor-pointer "> 
    <!-- avatar -->
    <div class="rounded-full h-11 w-11 border border-gray-400 mx-3">
      <img :src="conversation.avatar" alt="" class="rounded-full w-full h-full">
    </div>
    <!-- content -->
    <div class="flex-1">
      <h2 class="font-bold font-mono">{{ conversation.name }}</h2>
      <p class="font-mono truncate max-w-180 text-gray-600 text-sm">{{ conversation.lastestMessage }}</p>
    </div>
    <!-- time & status -->
    <div class="w-12 text-center">
      {{ conversation.timeStamp }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Conversation',
  props: ['conversation'],
  mounted() {
    console.log("mou")
  }
}
</script>

<style>

</style>