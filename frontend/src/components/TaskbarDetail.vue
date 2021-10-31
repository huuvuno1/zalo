<template>
  <div class="md:max-w-xs flex-grow md:w-80 border-r border-gray-200 md:block">
    <!-- box option -->
    <!-- search -->
    <search />
    
    <!-- box contact -->
    <div class="">
        <!-- title -->
        <div class="flex border-b border-gray-200  p-2 justify-between">
            <div class="font-bold ">
                Tất cả tin nhắn
            </div>
    <!-- create group -->
            <div class="w-10 text-right">
                <i class='bx bx-group cursor-pointer text-xl' title="Tạo nhóm chat"></i>
            </div>
        </div>

        <div class="overflow-y-scroll overflow-x-hidden h-96 relative" id="list__contact">
            <conversation v-for="conversation in conversations" :key="conversation.id" 
                :conversation="conversation" @click="changeBack"/>
        </div>
        
        
    </div>
</div>
</template>

<script>
import Conversation from './Conversation.vue'
import Search from './Search.vue'
import { mapMutations } from 'vuex'

export default {
    name: 'TaskbarDetail',
    components: {
        Conversation,
        Search
    },
    props: {
        conversations: Array
    },
    methods: {
        ...mapMutations(['changeBack'])
    }
}
</script>

<style lang="scss">
.router-link-active.router-link-exact-active{
    display: block;
    background-color: #e5efff;
}

</style>