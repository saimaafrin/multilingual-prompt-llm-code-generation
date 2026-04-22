class _M:
    from datetime import datetime
    
    class CalendarUtil:
        def __init__(self):
            self.events = []
        
        def get_events(self, date):
            """
            获取给定日期的所有事件。
            :param date: 要获取事件的日期，datetime。
            :return: 给定日期的事件列表，list。
            >>> calendar = CalendarUtil()
            >>> calendar.events = [{'date': datetime(2023, 1, 1, 0, 0), 'start_time': datetime(2023, 1, 1, 0, 0), 'end_time': datetime(2023, 1, 1, 1, 0), 'description': '新年'}]
            >>> calendar.get_events(datetime(2023, 1, 1, 0, 0))
            [{'date': datetime.datetime(2023, 1, 1, 0, 0), 'start_time': datetime.datetime(2023, 1, 1, 0, 0), 'end_time': datetime.datetime(2023, 1, 1, 1, 0), 'description': '新年'}]
    
            """
            result = []
            for event in self.events:
                # 比较日期部分（年、月、日）
                if (event['date'].year == date.year and 
                    event['date'].month == date.month and 
                    event['date'].day == date.day):
                    result.append(event)
            return result