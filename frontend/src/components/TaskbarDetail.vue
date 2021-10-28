<template>
  <div class="md:max-w-xs flex-1 md:w-80 border-r border-gray-200 hidden md:block">
    <!-- box option -->
    <div class="px-2 py-4 flex">
        <!-- search -->
        <search />
        <!-- create group -->
        <div class="w-10 text-right">
            <i class='bx bx-group cursor-pointer text-xl' title="Tạo nhóm chat"></i>
        </div>
    </div>
    <!-- box contact -->
    <div class="">
        <!-- title -->
        <div class="font-bold border-b border-gray-200  p-2">
            Tất cả tin nhắn
        </div>

        <div class="overflow-y-scroll overflow-x-hidden h-96 relative" id="list__contact">
            <conversation v-for="conversation in conversations" :key="conversation.id" :conversation="conversation" />
        </div>
        
        
    </div>
</div>
</template>

<script>
import Conversation from './Conversation.vue'
import Search from './Search.vue'

export default {
    name: 'TaskbarDetail',
    components: {
        Conversation,
        Search
    },
    props: {
        conversations: Array
    }
}
</script>

<style>

</style>