<template>
    <div
      class="box"
      :style="{'background-color': childColor}"
      :class="{'selected' : selectedIdx == myIdx}"
      @click="clickEvent">
        {{ childColor }}
    </div>
</template>

<script setup>
    const props = defineProps({
        'childColor': String,
        'myIdx': Number,
        'selectedIdx': Number,
    })

    // const emits = defineProps([myClick])

    const clickEvent = () => {
        console.log(props.childColor, '클릭')
        emits('myClick')
    }

</script>

<style scoped>
  .box {
    width: 200px;
    height: 200px;
    margin: 10px;
    transition: .2s;
  }

  .box:hover {
    box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24) , 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  }

  .selected {
    box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24) , 0 17px 50px 0 rgba(0, 0, 0, 0.19);
  }
</style>