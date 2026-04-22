class _M:
    class Thermostat:
        def __init__(self, current_temp, target_temp, mode):
            """
            初始化恒温器
            :param current_temp: float, 当前温度
            :param target_temp: float, 目标温度
            :param mode: str, 操作模式 ('heat', 'cool', 'auto')
            """
            self.current_temp = current_temp
            self.target_temp = target_temp
            self.mode = mode
        
        def auto_set_mode(self):
            """
            根据当前温度和目标温度自动设置操作模式
            如果当前温度低于目标温度，设置为 'heat'
            如果当前温度高于目标温度，设置为 'cool'
            如果当前温度等于目标温度，保持当前模式
            """
            if self.current_temp < self.target_temp:
                self.mode = 'heat'
            elif self.current_temp > self.target_temp:
                self.mode = 'cool'
        
        def simulate_operation(self):
            """
            模拟恒温器的操作。它将自动启动 auto_set_mode 方法以设置操作模式，
            然后根据操作模式自动调整当前温度，直到达到目标温度。
            :return time: int，完成模拟所需的时间。
            >>> thermostat = Thermostat(20.4, 37.5, 'cool')
            >>> thermostat.simulate_operation()
            18
            """
            time = 0
            
            # 自动设置操作模式
            self.auto_set_mode()
            
            # 根据操作模式调整温度，直到达到目标温度
            while self.current_temp != self.target_temp:
                if self.mode == 'heat':
                    # 加热模式：每次增加1度
                    self.current_temp += 1
                elif self.mode == 'cool':
                    # 制冷模式：每次减少1度
                    self.current_temp -= 1
                
                time += 1
                
                # 检查是否达到目标温度
                if self.current_temp == self.target_temp:
                    break
            
            return time